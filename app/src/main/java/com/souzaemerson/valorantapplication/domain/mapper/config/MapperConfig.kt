package com.souzaemerson.valorantapplication.domain.mapper.config

import com.souzaemerson.valorantapplication.data.model.Data
import com.souzaemerson.valorantapplication.domain.mapper.AgentDomain

object MapperConfig {

    fun agentResponseToDomain(response: Data): AgentDomain =
        AgentDomain(
            uuid = response.uuid,
            displayName = response.displayName,
            displayIcon = response.displayIcon,
            description = response.description,
            role = response.role,
            fullPortrait = response.fullPortrait,
            background = response.background,
            voiceLine = response.voiceLine,
            isPlayableCharacter = response.isPlayableCharacter,
            ability = response.abilities
        )
}