package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepository
import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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