package com.souzaemerson.valorantapplication.data.network

import com.souzaemerson.valorantapplication.data.model.AgentResponse
import retrofit2.http.GET

interface Service {

    @GET("/v1/agents")
    suspend fun getAgents(): AgentResponse
}