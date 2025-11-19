package com.example.mycatsapplication.network.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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