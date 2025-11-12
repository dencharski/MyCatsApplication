package com.example.mycatsapplication.di

import com.example.mycatsapplication.network.AuthInterceptor
import com.example.mycatsapplication.network.LoggingInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterceptorModule {
/*
    @Binds
    @Singleton
    abstract fun bindAuthInterceptor(authInterceptor: AuthInterceptor): Interceptor


    @Binds
    @Singleton
    abstract fun bindLoggingInterceptor(loggingInterceptor: LoggingInterceptor): Interceptor
*/

}