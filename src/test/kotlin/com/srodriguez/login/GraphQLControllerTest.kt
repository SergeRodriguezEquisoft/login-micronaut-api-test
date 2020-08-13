package com.srodriguez.login

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class GraphQLControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    private val query = """{users {
                          id
                          username
                          password
                          email
                        }}""".trimIndent()

    data class QueryRequest(val query: String)
    data class Response(val data: Users)
    data class Users(val users: List<UserResponse>)
    data class UserResponse(val id: String, val username: String)

    @Test
    fun queryForUsers(){
        val response = client.toBlocking()
                .exchange(HttpRequest.POST("/graphql", QueryRequest(query)), Response::class.java
                                               )
        assertEquals(2, response.body.get().data.users.size)
        assertEquals("1", response.body.get().data.users[0].id)

    }
}