package com.ggardet.agenticembabel.controller

import com.embabel.agent.api.common.autonomy.AgentInvocation
import com.embabel.agent.core.AgentPlatform
import com.embabel.agent.core.ProcessOptions
import com.ggardet.agenticembabel.model.BestJoke
import com.ggardet.agenticembabel.model.JokeRequest
import org.springframework.web.bind.annotation.*

/**
 * REST controller for joke generation endpoints
 */
@RestController
@RequestMapping("/api/jokes")
class JokeController(
    private val agentPlatform: AgentPlatform
) {

    /**
     * Generates programming jokes and returns the best one
     *
     * Example: GET /api/jokes/best?topic=Kotlin&count=3
     */
    @GetMapping("/best")
    fun getBestJoke(
        @RequestParam(defaultValue = "programming") topic: String,
        @RequestParam(defaultValue = "5") count: Int
    ): String {
        val request = JokeRequest(topic, count)

        val invocation = AgentInvocation.builder(agentPlatform)
            .options(
                ProcessOptions.builder()
                    .verbosity { v -> v.showPrompts(false) }
                    .build()
            )
            .build(BestJoke::class.java)

        val bestJoke = invocation.invoke(request)
        return bestJoke.joke.text
    }
}
