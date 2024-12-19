package webbank

import kotlinx.serialization.Serializable

@Serializable
data class User(val text: String, val id: String)