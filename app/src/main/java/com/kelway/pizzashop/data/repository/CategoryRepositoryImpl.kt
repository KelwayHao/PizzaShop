package com.kelway.pizzashop.data.repository

import com.kelway.pizzashop.data.data.CategoryDatabase
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepositoryImpl() : CategoryRepository {
    override suspend fun getCategoryDatabase(): List<Category> {
        return withContext(Dispatchers.IO) {
            return@withContext CategoryDatabase.listCategoryType
        }
    }
}