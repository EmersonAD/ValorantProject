package com.souzaemerson.valorantapplication.data.repository.agent

import com.souzaemerson.valorantapplication.data.model.AgentResponse

interface AgentRepository {
    suspend fun getAgents(): AgentResponse
}