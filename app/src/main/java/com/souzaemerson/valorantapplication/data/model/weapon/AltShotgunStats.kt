package com.souzaemerson.valorantapplication.data.model.weapon


import com.google.gson.annotations.SerializedName


data class AltShotgunStats(
    @SerializedName("burstRate")
    val burstRate: Double,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int,
)