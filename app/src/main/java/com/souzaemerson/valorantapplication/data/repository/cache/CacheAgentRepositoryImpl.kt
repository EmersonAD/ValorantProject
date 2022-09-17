package com.souzaemerson.valorantapplication.data.repository.cache

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.data.util.const.KEY_AGENT
import com.souzaemerson.valorantapplication.domain.repository.cache.CacheAgentRepository
import com.souzaemerson.valorantapplication.hawk.ModuleHawk
import javax.inject.Inject

class CacheAgentRepositoryImpl @Inject constructor() : CacheAgentRepository {
    override fun exists(): Boolean = ModuleHawk.contains(KEY_AGENT)

    override fun get(): List<AgentData> = ModuleHawk.get(KEY_AGENT)

    override fun add(agents: List<AgentData>) {
        if (exists()) {
            delete(KEY_AGENT)
        }
        ModuleHawk.put(KEY_AGENT, agents)
    }

    override fun delete(key: String) {
        if (exists()) ModuleHawk.delete(key)
    }
}