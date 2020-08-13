package com.srodriguez.login

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.srodriguez.login")
		.start()
}

