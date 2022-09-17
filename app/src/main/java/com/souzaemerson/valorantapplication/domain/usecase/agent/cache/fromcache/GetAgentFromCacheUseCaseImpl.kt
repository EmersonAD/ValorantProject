package com.souzaemerson.valorantapplication.domain.usecase.agent.cache.fromcache

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.domain.repository.cache.CacheAgentRepository
import javax.inject.Inject

class GetAgentFromCacheUseCaseImpl @Inject constructor
    (private val cacheAgentRepository: CacheAgentRepository): GetAgentFromCacheUseCase {

    override fun invoke(): List<AgentData> {
        return if (cacheAgentRepository.exists()) {
            cacheAgentRepository.get()
        } else {
            emptyList()
        }
    }
}