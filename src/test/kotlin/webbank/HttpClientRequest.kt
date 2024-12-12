package webbank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.*
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


	@Test
	fun testCreateUser() = testApplication {
		application {
			module()
		}
		val json = Json { ignoreUnknownKeys = true }
		val response = client.post("/create-user?BobSmith")
		assertEquals(HttpStatusCode.OK, response.status)

		val responseAsJson = json.parseToJsonElement(response.bodyAsText())
		assertEquals("User BobSmith created successfully", responseAsJson.jsonObject.get("text")?.jsonPrimitive?.content)
		assertTrue(responseAsJson.jsonObject.get("id")?.jsonPrimitive?.content?.length == 10)

	}



}
