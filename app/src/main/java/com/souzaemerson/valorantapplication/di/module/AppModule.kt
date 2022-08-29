package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepositoryImpl
import com.souzaemerson.valorantapplication.domain.repository.login.LoginRepository
import com.souzaemerson.valorantapplication.data.repository.login.LoginRepositoryImpl
import com.souzaemerson.valorantapplication.domain.usecase.login.UserSignInUseCase
import com.souzaemerson.valorantapplication.domain.usecase.login.UserSignInUseCaseImpl
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

    @Singleton
    @Binds
    abstract fun bindLoginRepository(
        loginRepository: LoginRepositoryImpl
    ): LoginRepository

    @Singleton
    @Binds
    abstract fun bindLoginUseCaseRepository(
        loginUseCaseRepository: UserSignInUseCaseImpl
    ): UserSignInUseCase
}