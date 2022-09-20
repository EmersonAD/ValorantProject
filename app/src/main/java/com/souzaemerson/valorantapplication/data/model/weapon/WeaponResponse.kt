package com.souzaemerson.valorantapplication.data.model.weapon


import com.google.gson.annotations.SerializedName


data class WeaponResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int,
) 