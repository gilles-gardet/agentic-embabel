package com.ggardet.agenticembabel.model

/**
 * Request to generate jokes about a specific programming topic
 */
data class JokeRequest(
    val topic: String = "programming", // Topic for jokes (e.g., "Java", "bugs", "programming")
    val count: Int = 5 // Number of jokes to generate
)
