package dev.antonioacuna.linkmein

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicControllerTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `Basic controller should return 'Hello, world!'`() {
        val response = restTemplate.getForEntity<String>("/")

        assert(response.statusCode.is2xxSuccessful)
        assert(response.body.equals("Hello, world!"))
    }
}