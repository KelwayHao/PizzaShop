package com.kelway.pizzashop.data.repository

import com.kelway.pizzashop.data.local_database.category.CategoryDao
import com.kelway.pizzashop.data.network_data.CategoryDatabase
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.repository.CategoryRepository
import com.kelway.pizzashop.utils.toCategory
import com.kelway.pizzashop.utils.toCategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override suspend fun getCategoryDatabase(): List<Category> {
        return withContext(Dispatchers.IO) {
            return@withContext CategoryDatabase.listCategoryType
        }
    }

    override suspend fun getCacheCategoryData(): List<Category> {
        return withContext(Dispatchers.IO) {
            return@withContext categoryDao.getAllCategoryDao().map { categoryEntity ->
                categoryEntity.toCategory()
            }
        }
    }

    override suspend fun saveCacheCategoryData(category: Category) {
        withContext(Dispatchers.IO) {
            if (!categoryDao.getAllCategoryDao().contains(category.toCategoryEntity())) {
                categoryDao.saveCategoryDao(category.toCategoryEntity())
            }
        }
    }
}