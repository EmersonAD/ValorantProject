package com.souzaemerson.valorantapplication.domain.usecase.agent.cache.firstaccess

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData

interface FirstAccessCacheUseCase {

    operator fun invoke(agents: List<AgentData>)
}