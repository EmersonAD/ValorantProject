package com.souzaemerson.valorantapplication.di.module

import com.souzaemerson.valorantapplication.di.qualifier.dispatcher.Default
import com.souzaemerson.valorantapplication.di.qualifier.dispatcher.Io
import com.souzaemerson.valorantapplication.di.qualifier.dispatcher.Main
import com.souzaemerson.valorantapplication.di.qualifier.dispatcher.Unconfined
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Singleton
    @Provides
    @Io
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    @Main
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Singleton
    @Provides
    @Default
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Singleton
    @Provides
    @Unconfined
    fun providesUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
}