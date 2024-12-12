package webbank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.*

class HttpClientRequest {

	@Test
	fun testRoot() = testApplication {
		application {
			module()
		}
		val response = client.get("/")
		assertEquals(HttpStatusCode.OK, response.status)
		assertEquals("Hello World!", response.bodyAsText())
	}
}
