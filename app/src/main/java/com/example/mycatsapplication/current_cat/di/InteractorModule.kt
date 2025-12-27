package com.example.mycatsapplication.current_cat.di

import com.example.mycatsapplication.current_cat.domain.api.CurrentCatInteractor
import com.example.mycatsapplication.current_cat.domain.impl.CurrentCatInteractorImpl
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
    abstract fun bindCurrentCatInteractor(
        currentCatInteractorImpl: CurrentCatInteractorImpl
    ): CurrentCatInteractor
}