package com.kelway.pizzashop.domain.interactor.category

import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryInteractorImpl @Inject constructor(private val categoryRepository: CategoryRepository) :
    CategoryInteractor {
    override suspend fun getCategory(): List<Category> {
        return categoryRepository.getCategoryDatabase()
    }

    override suspend fun getAllCacheCategory(): List<Category> {
        return categoryRepository.getCacheCategoryData()
    }

    override suspend fun saveCacheCategory(category: Category) {
        categoryRepository.saveCacheCategoryData(category)
    }
}