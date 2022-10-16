package com.kelway.pizzashop.presentation.listener

import com.kelway.pizzashop.domain.model.CategoryType

interface SelectingCategoryClickListener {
    fun selectCategory(categoryType: CategoryType)
}