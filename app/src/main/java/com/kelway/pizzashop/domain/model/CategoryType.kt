package com.kelway.pizzashop.domain.model

import com.kelway.pizzashop.R

enum class CategoryType(val nameItem: Int) {
    PIZZA(R.string.category_pizza),
    COMBO(R.string.category_combo),
    DESSERTS(R.string.category_desserts),
    DRINKS(R.string.category_drinks)
}