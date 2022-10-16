package com.kelway.pizzashop.data.local_database.category

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAllCategoryDao(): List<CategoryEntity>

    @Insert
    suspend fun saveCategoryDao(categoryEntity: CategoryEntity)
}