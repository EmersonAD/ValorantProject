package com.souzaemerson.valorantapplication.domain.repository.cache

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData

interface CacheAgentRepository {

    fun exists(): Boolean
    fun get(): List<AgentData>
    fun add(agents: List<AgentData>)
    fun delete(key: String)
}