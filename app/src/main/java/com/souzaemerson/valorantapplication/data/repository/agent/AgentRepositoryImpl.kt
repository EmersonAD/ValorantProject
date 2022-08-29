package com.souzaemerson.valorantapplication.data.repository.agent

import com.souzaemerson.valorantapplication.data.model.valorant.AgentResponse
import com.souzaemerson.valorantapplication.data.remote.Service
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(private val api: Service) : AgentRepository {
    override suspend fun getAgents(): AgentResponse =
        api.getAgents()
}