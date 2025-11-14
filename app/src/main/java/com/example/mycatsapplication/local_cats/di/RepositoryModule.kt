package com.example.mycatsapplication.local_cats.di

import com.example.mycatsapplication.local_cats.data.api.ConverterLocalCat
import com.example.mycatsapplication.local_cats.data.api.LocalCatRepository
import com.example.mycatsapplication.local_cats.data.impl.ConverterLocalCatImpl
import com.example.mycatsapplication.local_cats.data.impl.LocalCatRepositoryImpl
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
    abstract fun bindLocalCatRepository(localCatRepository: LocalCatRepositoryImpl): LocalCatRepository

    @Binds
    @Singleton
    abstract fun bindConverterLocalCat(converterLocalCat: ConverterLocalCatImpl): ConverterLocalCat
}