package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.domain.usecase.GetAgentUseCase
import com.souzaemerson.valorantapplication.domain.usecase.GetAgentUseCaseImpl
import com.souzaemerson.valorantapplication.domain.usecase.agent.cache.firstaccess.FirstAccessCacheUseCase
import com.souzaemerson.valorantapplication.domain.usecase.agent.cache.firstaccess.FirstAccessCacheUseCaseImpl
import com.souzaemerson.valorantapplication.domain.usecase.agent.cache.fromcache.GetAgentFromCacheUseCase
import com.souzaemerson.valorantapplication.domain.usecase.agent.cache.fromcache.GetAgentFromCacheUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleUseCase {

    @Singleton
    @Binds
    abstract fun bindAgentUseCase(
        getAgentUseCase: GetAgentUseCaseImpl,
    ): GetAgentUseCase

    @Singleton
    @Binds
    abstract fun bindFirstAccessCacheUseCase(
        firstAccessCacheUseCase: FirstAccessCacheUseCaseImpl,
    ): FirstAccessCacheUseCase

    @Singleton
    @Binds
    abstract fun bindGetAgentFromCacheUseCase(
        getAgentFromCacheUseCase: GetAgentFromCacheUseCaseImpl,
    ): GetAgentFromCacheUseCase
}