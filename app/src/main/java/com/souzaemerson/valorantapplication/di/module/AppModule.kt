package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepositoryImpl
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import com.souzaemerson.valorantapplication.domain.usecase.GetAgentUseCase
import com.souzaemerson.valorantapplication.domain.usecase.GetAgentUseCaseImpl
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindAgentRepository(
        agentRepository: AgentRepositoryImpl
    ): AgentRepository

    @Singleton
    @Binds
    abstract fun bindAgentUseCase(
        getAgentUseCase: GetAgentUseCaseImpl
    ): GetAgentUseCase
}