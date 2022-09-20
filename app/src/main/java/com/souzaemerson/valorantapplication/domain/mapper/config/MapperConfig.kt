package com.souzaemerson.valorantapplication.domain.mapper.config

import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.data.model.weapon.Data
import com.souzaemerson.valorantapplication.domain.mapper.AgentDomain
import com.souzaemerson.valorantapplication.domain.mapper.WeaponDomain

object MapperConfig {

    fun mapDataToDataDomain(dataResponse: List<AgentData>): List<AgentDomain> {

        return dataResponse.map { agent ->
            AgentDomain(
                uuid = agent.uuid,
                displayName = agent.displayName,
                displayIcon = agent.displayIcon,
                description = agent.description,
                role = agent.role,
                fullPortrait = agent.fullPortrait,
                background = agent.background,
                voiceLine = agent.voiceLine,
                isPlayableCharacter = agent.isPlayableCharacter,
                ability = agent.abilities
            )
        }
    }

    fun mapWeaponDataToWeaponDomain(dataWeapon: List<Data>): List<WeaponDomain> {

        return dataWeapon.map { weapon ->
            WeaponDomain(
                category = weapon.category,
                skinDefaultUuid = weapon.defaultSkinUuid,
                skinDefaultIcon = weapon.displayIcon,
                weaponName = weapon.displayName,
                skins = weapon.skins,
                weaponStats = weapon.weaponStats,
                uuid = weapon.uuid
            )
        }
    }
}