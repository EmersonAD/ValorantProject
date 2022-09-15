package com.souzaemerson.valorantapplication.data.repository.agent

import com.souzaemerson.valorantapplication.data.model.valorant.AgentResponse
import com.souzaemerson.valorantapplication.data.remote.ValorantService
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(private val api: ValorantService) : AgentRepository {
    override suspend fun getAgents(): AgentResponse = api.getAgents()
}