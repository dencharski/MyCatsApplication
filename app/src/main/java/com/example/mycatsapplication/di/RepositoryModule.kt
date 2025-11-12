package com.example.mycatsapplication.di

import com.example.mycatsapplication.walking_cats.data.api.CatConverter
import com.example.mycatsapplication.walking_cats.data.api.WalkingCatsRepository
import com.example.mycatsapplication.walking_cats.data.impl.CatConverterImpl
import com.example.mycatsapplication.walking_cats.data.impl.WalkingCatsRepositoryImpl
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
    abstract fun bindWalkingCatsRepository(
        walkingCatsRepositoryImpl: WalkingCatsRepositoryImpl
    ): WalkingCatsRepository

    @Binds
    @Singleton
    abstract fun bindCatConverter(
        catConverterImpl: CatConverterImpl
    ): CatConverter
}