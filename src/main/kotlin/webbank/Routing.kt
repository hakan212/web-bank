package webbank

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlin.random.Random

fun Application.configureRouting() {
	routing {
		get("/") {
			call.respondText("Hello World!")
		}
		post("/create-user") {
			val userLong = Random.nextLong()
			val userID = userLong.toString().slice(1..10)
			println(userLong)
			println(userID)
			call.respondText(Json.encodeToString(User("User BobSmith created successfully", userID)))
		}
	}
}
