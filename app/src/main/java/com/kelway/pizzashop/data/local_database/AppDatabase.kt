package com.kelway.pizzashop.data.local_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kelway.pizzashop.data.local_database.banner.BannerDao
import com.kelway.pizzashop.data.local_database.banner.BannerEntity
import com.kelway.pizzashop.data.local_database.category.CategoryDao
import com.kelway.pizzashop.data.local_database.category.CategoryEntity
import com.kelway.pizzashop.data.local_database.pizza.PizzaDao
import com.kelway.pizzashop.data.local_database.pizza.PizzaEntity

@Database(
    entities = [BannerEntity::class, CategoryEntity::class, PizzaEntity::class],
    version = AppDatabase.VERSION_DB
)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        const val VERSION_DB = 1
    }

    abstract fun getBannerDao(): BannerDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getPizzaDao(): PizzaDao
}