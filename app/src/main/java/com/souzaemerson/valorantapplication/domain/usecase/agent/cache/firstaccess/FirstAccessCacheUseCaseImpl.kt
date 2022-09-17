package com.souzaemerson.valorantapplication.domain.usecase.agent.cache.firstaccess

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.domain.repository.cache.CacheAgentRepository
import javax.inject.Inject

class FirstAccessCacheUseCaseImpl @Inject constructor
    (private val cacheAgentRepository: CacheAgentRepository) : FirstAccessCacheUseCase {

    override fun invoke(agents: List<AgentData>) {
        if (!cacheAgentRepository.exists()) {
            cacheAgentRepository.add(agents)
        }
    }
}