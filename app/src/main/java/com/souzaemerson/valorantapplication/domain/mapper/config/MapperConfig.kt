package com.souzaemerson.valorantapplication.domain.mapper.config

import com.souzaemerson.valorantapplication.data.model.Data
import com.souzaemerson.valorantapplication.domain.mapper.AgentDomain

object MapperConfig {

    fun mapDataToDataDomain(dataResponse: List<Data>): List<AgentDomain> {

        return dataResponse.map { dataResponse ->
            AgentDomain(
                uuid = dataResponse.uuid,
                displayName = dataResponse.displayName,
                displayIcon = dataResponse.displayIcon,
                description = dataResponse.description,
                role = dataResponse.role,
                fullPortrait = dataResponse.fullPortrait,
                background = dataResponse.background,
                voiceLine = dataResponse.voiceLine,
                isPlayableCharacter = dataResponse.isPlayableCharacter,
                ability = dataResponse.abilities
            )
        }
    }
}