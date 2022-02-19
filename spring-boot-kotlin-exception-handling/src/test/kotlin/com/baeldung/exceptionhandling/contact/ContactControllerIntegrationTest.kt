package com.baeldung.exceptionhandling.contact

import com.baeldung.exceptionhandling.ExceptionHandlingDemoApplication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = arrayOf(ExceptionHandlingDemoApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ContactControllerIntegrationTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun whenCreateContactIsCalled_thenShouldReturnCreatedContact() {
        val contact = Contact("Praseed", "+91 9746 450318", "friends")
        val request = HttpEntity(contact, HttpHeaders())
        val response = testRestTemplate.exchange(
            "/contact",
            HttpMethod.PUT,
            request,
            Contact::class.java
        )

        Assertions.assertEquals(HttpStatus.OK, response?.statusCode)
        Assertions.assertEquals(contact, response?.body)
    }
}