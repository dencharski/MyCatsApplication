package com.example.mycatsapplication.di

import javax.inject.Qualifier

class Qualifiers {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthInterceptor


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LoggingInterceptor

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CatsOkHttpClient
}