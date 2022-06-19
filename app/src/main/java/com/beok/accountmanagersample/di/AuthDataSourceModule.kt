package com.beok.accountmanagersample.di

import com.beok.accountmanagersample.data.AuthLocalDataSource
import com.beok.accountmanagersample.data.AuthLocalDataSourceImpl
import com.beok.accountmanagersample.data.AuthRemoteDataSource
import com.beok.accountmanagersample.data.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AuthDataSourceModule {

    @Binds
    @Singleton
    fun bindsAuthLocalDatSource(impl: AuthLocalDataSourceImpl): AuthLocalDataSource

    @Binds
    @Singleton
    fun bindsAuthRemoteDataSource(impl: AuthRemoteDataSourceImpl): AuthRemoteDataSource
}
