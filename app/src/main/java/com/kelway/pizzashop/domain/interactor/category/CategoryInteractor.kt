package com.kelway.pizzashop.domain.interactor.category

import com.kelway.pizzashop.domain.model.Category

interface CategoryInteractor {
    suspend fun getCategory(): List<Category>
    suspend fun getAllCacheCategory(): List<Category>
    suspend fun saveCacheCategory(category: Category)
}