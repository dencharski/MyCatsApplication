package com.example.mycatsapplication.local_cats.di

import android.content.Context
import android.content.SharedPreferences
import com.example.mycatsapplication.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            Utils.getCatSharedPreferences(),
            Context.MODE_PRIVATE
        )
    }
}