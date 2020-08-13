package com.srodriguez.login.graphql.schema

import com.expediagroup.graphql.annotations.GraphQLDescription
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

data class Users(val id: String,
                              val username: String?,
                              val password: String,
                              val email:String)

class UsersQuery{
    @Suppress("unused")
    @GraphQLDescription("Use this query to get all users")
    suspend fun users(): List<Users> {
        delay(1000)
        return listOf(
                Users("1", "SRodriguez", "SRodriguez", "serge.rodriguez@equisoft.com"),
                Users("2", "JNicloux", "JNicloux", "jeremie.nicloux@equisoft.com"))
    }
    }
