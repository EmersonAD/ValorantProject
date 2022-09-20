package com.souzaemerson.valorantapplication.data.model.weapon


import com.google.gson.annotations.SerializedName


data class AirBurstStats(
    @SerializedName("burstDistance")
    val burstDistance: Double,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int,
)