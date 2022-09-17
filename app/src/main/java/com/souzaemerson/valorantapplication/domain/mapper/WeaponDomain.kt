package com.souzaemerson.valorantapplication.domain.mapper

import com.souzaemerson.valorantapplication.data.model.weapon.Skin
import com.souzaemerson.valorantapplication.data.model.weapon.WeaponStats

data class WeaponDomain(
    val category: String,
    val skinDefaultUuid: String,
    val weaponName: String,
    val skins: List<Skin>,
    val uuid: String,
    val weaponStats: WeaponStats
)
