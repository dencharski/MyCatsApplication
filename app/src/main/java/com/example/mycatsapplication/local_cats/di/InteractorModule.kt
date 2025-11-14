package com.example.mycatsapplication.local_cats.di

import com.example.mycatsapplication.local_cats.domain.api.LocalCatInteractor
import com.example.mycatsapplication.local_cats.domain.impl.LocalCatInteractorImpl
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
    abstract fun bindLocalCatInteractor(localCatInteractor: LocalCatInteractorImpl): LocalCatInteractor
}