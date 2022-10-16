package com.kelway.pizzashop.domain.repository

import com.kelway.pizzashop.domain.model.Category

interface CategoryRepository {
    suspend fun getCategoryDatabase(): List<Category>
}