package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepositoryImpl
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import dagger.Binds
import dagger.Module
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
}