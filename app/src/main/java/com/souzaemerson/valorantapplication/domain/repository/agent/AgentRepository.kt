package com.souzaemerson.valorantapplication.domain.repository.agent

import com.souzaemerson.valorantapplication.data.model.valorant.AgentResponse

interface AgentRepository {
    suspend fun getAgents(): AgentResponse
}