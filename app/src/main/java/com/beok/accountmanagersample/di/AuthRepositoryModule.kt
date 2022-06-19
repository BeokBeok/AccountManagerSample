package com.beok.accountmanagersample.di

import com.beok.accountmanagersample.data.AuthRepositoryImpl
import com.beok.accountmanagersample.domain.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AuthRepositoryModule {

    @Binds
    @Singleton
    fun bindsAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}
