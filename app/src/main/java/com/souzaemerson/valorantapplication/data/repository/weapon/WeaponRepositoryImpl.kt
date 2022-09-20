package com.souzaemerson.valorantapplication.data.repository.weapon

import com.souzaemerson.valorantapplication.data.model.weapon.WeaponResponse
import com.souzaemerson.valorantapplication.data.remote.ValorantService
import com.souzaemerson.valorantapplication.domain.repository.weapon.WeaponRepository
import javax.inject.Inject

class WeaponRepositoryImpl @Inject constructor(private val api: ValorantService) :
    WeaponRepository {
    override suspend fun getWeapons(): WeaponResponse = api.getWeapons()
}