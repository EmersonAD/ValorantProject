package com.souzaemerson.valorantapplication.domain.usecase.agent.cache.fromcache

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData

interface GetAgentFromCacheUseCase {

    operator fun invoke(): List<AgentData>
}