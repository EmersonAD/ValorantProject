package com.souzaemerson.valorantapplication.domain.repository.weapon

import com.souzaemerson.valorantapplication.data.model.weapon.WeaponResponse

interface WeaponRepository {
    suspend fun getWeapons(): WeaponResponse
}