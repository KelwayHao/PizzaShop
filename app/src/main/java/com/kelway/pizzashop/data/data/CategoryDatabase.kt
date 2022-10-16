package com.kelway.pizzashop.data.data

import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.CategoryType

class CategoryDatabase() {
    companion object {
        val listCategoryType = listOf(
            Category(CategoryType.PIZZA),
            Category(CategoryType.COMBO),
            Category(CategoryType.DESSERTS),
            Category(CategoryType.DRINKS)
        )
    }
}