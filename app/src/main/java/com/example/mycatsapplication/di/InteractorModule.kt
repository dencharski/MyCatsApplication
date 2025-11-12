package com.example.mycatsapplication.di

import com.example.mycatsapplication.walking_cats.domain.api.WalkingCatsInteractor
import com.example.mycatsapplication.walking_cats.domain.impl.WalkingCatsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {
    @Binds
    @Singleton
    abstract fun bindWalkingCatsInteractor(
        walkingCatsInteractorImpl: WalkingCatsInteractorImpl
    ): WalkingCatsInteractor
}