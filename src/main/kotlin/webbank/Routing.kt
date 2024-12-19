package webbank

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

fun Application.configureRouting() {
	routing {
		get("/") {
			call.respondText("Hello World!")
		}
		post("/create-user") {
			call.respondText(Json.encodeToString(User("User BobSmith created successfully", "1111111111")))
		}
	}
}
