package com.srodriguez.login.endpoints

import com.srodriguez.login.models.Users
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

@Controller("/")
open class RegisterController {


    @Put("/register")
    fun register(@Body user: Users): HttpResponse<*> {

        val url = "jdbc:postgresql://localhost:5432/login"
        val props = Properties()
        props.setProperty("user", "login")
        props.setProperty("password", "password")
        props.setProperty("ssl", "false")

        var postRequestUsername: String? = user.username
        var postRequestEmail: String = user.email
        var postRequestPassword: String = user.password
        var successfulInsert: Int = 0

        try {
            val conn: Connection = DriverManager.getConnection(url, props)
            println("Connected to the PostgreSQL server successfully.")
            val st = conn.createStatement()
            val query = "INSERT INTO users(username, password, email) VALUES ('$postRequestUsername','$postRequestPassword', '$postRequestEmail');"
            val rs = st.executeUpdate(query)
            successfulInsert = rs

            st.close();

        } catch (e: SQLException) {

            println(e.message)
        }

        return if (successfulInsert == 1)
            HttpResponse.ok(true)
        else
            HttpResponse.ok(false)

    }
}
