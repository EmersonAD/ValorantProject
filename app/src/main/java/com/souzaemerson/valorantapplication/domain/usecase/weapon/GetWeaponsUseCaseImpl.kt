package com.souzaemerson.valorantapplication.domain.usecase.weapon

import com.souzaemerson.valorantapplication.core.exception.NoDataResponseException
import com.souzaemerson.valorantapplication.domain.mapper.WeaponDomain
import com.souzaemerson.valorantapplication.domain.mapper.config.MapperConfig
import com.souzaemerson.valorantapplication.domain.repository.weapon.WeaponRepository
import javax.inject.Inject

class GetWeaponsUseCaseImpl @Inject constructor(private val weaponRepository: WeaponRepository) :
    GetWeaponsUseCase {

    override suspend fun getWeapons(): List<WeaponDomain> {
        weaponRepository.getWeapons().let { weaponResponse ->
            return if (weaponResponse.status == 200) {
                MapperConfig.mapWeaponDataToWeaponDomain(weaponResponse.data)
            } else {
                throw NoDataResponseException()
            }
        }
    }
}