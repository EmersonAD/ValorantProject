package com.souzaemerson.valorantapplication.domain.mapper

import com.souzaemerson.valorantapplication.data.model.weapon.Skin
import com.souzaemerson.valorantapplication.data.model.weapon.WeaponStats

data class WeaponDomain(
    val category: String,
    val skinDefaultUuid: String,
    val skinDefaultIcon: String,
    val weaponName: String,
    val skins: List<Skin>,
    val weaponStats: WeaponStats?,
    val uuid: String
)
