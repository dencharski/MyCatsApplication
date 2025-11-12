package com.example.mycatsapplication.di


import com.example.mycatsapplication.network.AuthInterceptor
import com.example.mycatsapplication.network.CatServices
import com.example.mycatsapplication.network.LoggingInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {
    @Qualifiers.AuthInterceptor
    @Singleton
    @Provides
    fun providesAuthInterceptor(): Interceptor = AuthInterceptor()

    @Qualifiers.LoggingInterceptor
    @Singleton
    @Provides
    fun providesLoggingInterceptor(): Interceptor = LoggingInterceptor()

    @Qualifiers.CatsOkHttpClient
    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Qualifiers.AuthInterceptor authInterceptor: Interceptor,
        @Qualifiers.LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideCatServices(@Qualifiers.CatsOkHttpClient okHttpClient: OkHttpClient): CatServices {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/images/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CatServices::class.java)
    }

}