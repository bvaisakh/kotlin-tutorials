package com.baeldung.exceptionhandling

import com.baeldung.exceptionhandling.contact.Contact
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
	classes = arrayOf(ExceptionHandlingDemoApplication::class),
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ContactControllerIntegrationTest {

	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun whenCreateContactIsCalled_thenShouldCreatedContact() {
		val result = testRestTemplate
			.exchange("/contact", HttpMethod.PUT, HttpEntity(null, HttpHeaders()), Contact::class.java)

		Assert.assertNotNull(result)
	}

}
