package com.kelway.pizzashop.data.di

import com.kelway.pizzashop.data.local_database.banner.BannerDao
import com.kelway.pizzashop.data.repository.BannerRepositoryImpl
import com.kelway.pizzashop.data.repository.CategoryRepositoryImpl
import com.kelway.pizzashop.data.repository.PizzaRepositoryImpl
import com.kelway.pizzashop.domain.repository.BannerRepository
import com.kelway.pizzashop.domain.repository.CategoryRepository
import com.kelway.pizzashop.domain.repository.PizzaRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideBannerRepository(bannerDao: BannerDao): BannerRepository {
        return BannerRepositoryImpl(bannerDao)
    }

    @Provides
    fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepositoryImpl()
    }

    @Provides
    fun providePizzaRepository(): PizzaRepository {
        return PizzaRepositoryImpl()
    }
}