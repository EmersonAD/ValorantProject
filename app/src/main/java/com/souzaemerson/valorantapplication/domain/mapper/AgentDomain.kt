package com.souzaemerson.valorantapplication.domain.mapper

import com.souzaemerson.valorantapplication.data.model.valorant.Ability
import com.souzaemerson.valorantapplication.data.model.valorant.Role
import com.souzaemerson.valorantapplication.data.model.valorant.VoiceLine

data class AgentDomain(
    val uuid: String,
    val displayName: String,
    val description: String,
    val role: Role,
    val displayIcon: String,
    val fullPortrait: String,
    val background: String,
    val voiceLine: VoiceLine,
    val ability: List<Ability>,
    val isPlayableCharacter: Boolean
)