package com.example.Szubair.ApiProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
class ApiProjectApplication

fun main(args: Array<String>) {
	runApplication<ApiProjectApplication>(*args)
}
