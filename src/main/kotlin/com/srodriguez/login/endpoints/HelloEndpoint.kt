package com.srodriguez.login.endpoints

//import io.micronaut.http.MediaType
//import io.micronaut.http.annotation.Controller
//import io.micronaut.http.annotation.Get
//import io.micronaut.http.annotation.PathVariable
//import io.micronaut.http.annotation.Produces
//import java.sql.Connection
//import java.sql.DriverManager
//import java.sql.SQLException
//import java.util.*
//
//@Controller("/")
//class HelloController {
//
//    @Get("/hello")
////    @Produces(MediaType.TEXT_PLAIN)
//    fun index(): Boolean {
//
//        val url = "jdbc:postgresql://localhost:5432/login"
//        val props = Properties()
//        props.setProperty("user", "login")
//        props.setProperty("password", "password")
//        props.setProperty("ssl", "false")
//        var username: String =""
//        var password: String =""
//
//        try {
//            val conn: Connection = DriverManager.getConnection(url, props)
//            println("Connected to the PostgreSQL server successfully.")
//            val st = conn.createStatement()
//            val rs = st.executeQuery("SELECT username, password, email from users WHERE users.username = 'SRodriguez';")
//
//            while (rs.next())
//            {
//
//                 username = rs.getString("username")
//                 password =rs.getString("password")
//
//
//            }
//            rs.close();
//            st.close();
//
//        } catch (e: SQLException) {
//            println(e.message)
//        }
//
//    return username == "faux"
//    }
//
//    @Get("/{numberOfBananas}")
//    @Produces(MediaType.TEXT_PLAIN)
//    fun numOfBananas(@PathVariable numberOfBananas: Int): String{
//        return "I have $numberOfBananas bananas"
//    }
//}