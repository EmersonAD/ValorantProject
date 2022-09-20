package com.souzaemerson.valorantapplication.domain.usecase.weapon

import com.souzaemerson.valorantapplication.domain.mapper.WeaponDomain

interface GetWeaponsUseCase {
    suspend fun getWeapons(): List<WeaponDomain>
}