package com.kelway.pizzashop.data.di

import android.content.Context
import androidx.room.Room
import com.kelway.pizzashop.data.local_database.AppDatabase
import com.kelway.pizzashop.data.local_database.banner.BannerDao
import com.kelway.pizzashop.data.local_database.category.CategoryDao
import com.kelway.pizzashop.data.local_database.pizza.PizzaDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideBannerDao(appDatabase: AppDatabase): BannerDao {
        return appDatabase.getBannerDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.getCategoryDao()
    }

    @Singleton
    @Provides
    fun providePizzaDao(appDatabase: AppDatabase): PizzaDao {
        return appDatabase.getPizzaDao()
    }
}