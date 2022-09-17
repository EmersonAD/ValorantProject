package com.souzaemerson.valorantapplication.domain.usecase

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import javax.inject.Inject

class GetAgentUseCaseImpl @Inject constructor(private val repository: AgentRepository) :
    GetAgentUseCase {
    override suspend operator fun invoke(): List<AgentData> {
        repository.getAgents().let { agentResponse ->
            return if (agentResponse.status == 200) agentResponse.data else emptyList()
        }
    }
}
