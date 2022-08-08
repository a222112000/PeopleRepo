package com.example.virginmoney.di

import com.example.virginmoney.repository.VirginRepo
import com.example.virginmoney.repository.VirginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideVirginRepository(virginRepositoryImpl: VirginRepositoryImpl):VirginRepo
}