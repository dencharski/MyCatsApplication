package com.example.mycatsapplication.current_cat.di


import com.example.mycatsapplication.current_cat.data.api.CurrentCatConverter
import com.example.mycatsapplication.current_cat.data.api.CurrentCatRepository
import com.example.mycatsapplication.current_cat.data.impl.CurrentCatConverterImpl
import com.example.mycatsapplication.current_cat.data.impl.CurrentCatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCurrentCatRepository(
        currentCatRepositoryImpl: CurrentCatRepositoryImpl
    ): CurrentCatRepository

    @Binds
    @Singleton
    abstract fun bindCurrentCatConverter(
        currentCatConverterImpl: CurrentCatConverterImpl
    ): CurrentCatConverter
}