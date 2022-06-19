package com.beok.accountmanagersample.di

import android.content.Context
import com.beok.accountmanagersample.auth.SampleAuthService
import com.beok.accountmanagersample.auth.SampleAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ServiceComponent::class)
object AuthServiceModule {

    @Provides
    @Singleton
    fun providesSampleAuthenticator(@ApplicationContext context: Context): SampleAuthenticator =
        SampleAuthenticator(context)

    @Provides
    @Singleton
    fun providesSampleAuthService(): SampleAuthService =
        SampleAuthService()
}
