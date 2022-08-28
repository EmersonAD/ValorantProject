package com.souzaemerson.valorantapplication.data.repository.agent

import com.souzaemerson.valorantapplication.data.model.AgentResponse
import com.souzaemerson.valorantapplication.data.remote.Service
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(private val api: Service) : AgentRepository {
    override suspend fun getAgents(): AgentResponse =
        api.getAgents()
}