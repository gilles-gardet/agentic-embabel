package com.ggardet.agenticembabel.agent

import com.embabel.agent.api.annotation.AchievesGoal
import com.embabel.agent.api.annotation.Action
import com.embabel.agent.api.annotation.Agent
import com.embabel.agent.api.common.OperationContext
import com.ggardet.agenticembabel.model.BestJoke
import com.ggardet.agenticembabel.model.JokeCollection
import com.ggardet.agenticembabel.model.JokeRequest

/**
 * Agent that generates programming jokes and selects the best one
 */
@Agent(description = "Generates programming jokes and finds the funniest one")
class JokeAgent {

    /**
     * First action: generates multiple programming jokes based on the request
     */
    @Action
    fun generateJokes(request: JokeRequest, context: OperationContext): JokeCollection {
        val prompt = """
            Generate ${request.count} funny programming jokes about "${request.topic}".
            For each joke, provide:
            - text: the joke text
            - humorScore: a score from 1-10 rating how funny it is

            Make the jokes creative, clever, and appropriate for programmers.
            Return them as a JokeCollection with a list of Joke objects.
        """.trimIndent()

        return context.ai()
            .withDefaultLlm()
            .createObject(prompt, JokeCollection::class.java)
    }

    /**
     * Final action: analyzes all jokes and selects the best one with reasoning
     */
    @AchievesGoal(description = "Select and return the best joke from the collection")
    @Action
    fun selectBestJoke(jokes: JokeCollection, context: OperationContext): BestJoke {
        val prompt = """
            Analyze these programming jokes and select the absolute best one:

            ${jokes.jokes.mapIndexed { index, joke ->
                "${index + 1}. ${joke.text} (Score: ${joke.humorScore})"
            }.joinToString("\n")}

            Consider:
            - Cleverness and wordplay
            - Relevance to programming
            - Original humor score
            - General appeal to developers

            Return the best joke along with a brief explanation of why it's the funniest.
        """.trimIndent()

        return context.ai()
            .withDefaultLlm()
            .createObject(prompt, BestJoke::class.java)
    }
}
