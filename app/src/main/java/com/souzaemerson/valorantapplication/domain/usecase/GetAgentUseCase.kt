package com.souzaemerson.valorantapplication.domain.usecase

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData

interface GetAgentUseCase {
    suspend operator fun invoke(): List<AgentData>
}