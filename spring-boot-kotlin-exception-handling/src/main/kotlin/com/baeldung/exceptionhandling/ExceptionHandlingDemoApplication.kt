package com.baeldung.exceptionhandling

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

@SpringBootApplication(
    scanBasePackages = ["com.baeldung.exceptionhandling"],
    exclude = [SecurityAutoConfiguration::class])
class ExceptionHandlingDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(ExceptionHandlingDemoApplication::class.java, *args)
}
