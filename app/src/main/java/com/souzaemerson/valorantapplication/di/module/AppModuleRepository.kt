package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepositoryImpl
import com.souzaemerson.valorantapplication.data.repository.cache.CacheAgentRepositoryImpl
import com.souzaemerson.valorantapplication.data.repository.weapon.WeaponRepositoryImpl
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import com.souzaemerson.valorantapplication.domain.repository.cache.CacheAgentRepository
import com.souzaemerson.valorantapplication.domain.repository.weapon.WeaponRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleRepository {

    @Singleton
    @Binds
    abstract fun bindAgentRepository(
        agentRepository: AgentRepositoryImpl,
    ): AgentRepository

    @Singleton
    @Binds
    abstract fun bindCacheAgentRepository(
        cacheAgentRepository: CacheAgentRepositoryImpl,
    ): CacheAgentRepository

    @Singleton
    @Binds
    abstract fun bindWeaponRepository(
        weaponRepository: WeaponRepositoryImpl
    ): WeaponRepository
}