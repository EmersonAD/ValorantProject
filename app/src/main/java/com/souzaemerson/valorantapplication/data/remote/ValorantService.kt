package com.souzaemerson.valorantapplication.data.remote

import com.souzaemerson.valorantapplication.data.model.valorant.AgentResponse
import com.souzaemerson.valorantapplication.data.model.weapon.WeaponResponse
import retrofit2.http.GET

interface ValorantService {
    @GET("/v1/agents")
    suspend fun getAgents(): AgentResponse

    @GET("/v1/weapons")
    suspend fun getWeapons(): WeaponResponse
}