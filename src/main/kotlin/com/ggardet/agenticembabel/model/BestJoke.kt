package com.ggardet.agenticembabel.model

/**
 * The best joke selected from a collection
 */
data class BestJoke(
    val joke: Joke,
    val reason: String // Explanation of why this is the best joke
)
