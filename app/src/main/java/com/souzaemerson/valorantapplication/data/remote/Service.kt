package com.souzaemerson.valorantapplication.data.remote

import com.souzaemerson.valorantapplication.data.model.valorant.AgentResponse
import retrofit2.http.GET

interface Service {
    @GET("/v1/agents")
    suspend fun getAgents(): AgentResponse
}