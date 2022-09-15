package com.souzaemerson.valorantapplication.domain.usecase

import com.souzaemerson.valorantapplication.data.model.valorant.Data

interface GetAgentUseCase {
    suspend fun getAgents(): List<Data>
}