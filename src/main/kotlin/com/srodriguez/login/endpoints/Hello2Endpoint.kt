package com.srodriguez.login.endpoints

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces


@Controller("/")
class Hello2Controller {
    @Produces(MediaType.TEXT_PLAIN)
    @Get("/{name}")
    fun hello(name: String): HttpResponse<String> {
        println("Hello, $name!")
        return HttpResponse.ok("Hello, $name!")
    }
}