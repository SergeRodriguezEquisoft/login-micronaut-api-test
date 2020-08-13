package com.srodriguez.login.endpoints

import com.fasterxml.jackson.databind.util.JSONPObject
import com.srodriguez.login.models.Users
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.reactivex.Flowable
import io.reactivex.Single
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

import javax.validation.constraints.Size


@Controller("/")
open class LoginController {


    @Post("/login")
    fun login(@Body user: Users): HttpResponse<*> {

        val url = "jdbc:postgresql://localhost:5432/login"
        val props = Properties()
        props.setProperty("user", "login")
        props.setProperty("password", "password")
        props.setProperty("ssl", "false")

        var postRequestEmail: String = user.email
        var databasePassword: String =""

        try {
            val conn: Connection = DriverManager.getConnection(url, props)
            println("Connected to the PostgreSQL server successfully.")
            val st = conn.createStatement()
            val query = "SELECT username, password, email FROM users WHERE users.email = '$postRequestEmail';"
            val rs = st.executeQuery(query)

            while (rs.next())
            {


                 databasePassword =rs.getString("password")


            }
            rs.close();
            st.close();

        } catch (e: SQLException) {

            println(e.message)
        }

        return if (user.password == databasePassword)
            HttpResponse.ok(true)
        else
            HttpResponse.ok(false)


    }
}
