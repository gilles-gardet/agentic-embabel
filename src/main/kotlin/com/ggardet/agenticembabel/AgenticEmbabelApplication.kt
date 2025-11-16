package com.ggardet.agenticembabel

import com.embabel.agent.config.annotation.EnableAgents
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAgents
class AgenticEmbabelApplication

fun main(args: Array<String>) {
	runApplication<AgenticEmbabelApplication>(*args)
}
