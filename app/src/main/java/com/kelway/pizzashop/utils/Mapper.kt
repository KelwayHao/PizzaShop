package com.kelway.pizzashop.utils

import com.kelway.pizzashop.data.local_database.banner.BannerEntity
import com.kelway.pizzashop.data.local_database.category.CategoryEntity
import com.kelway.pizzashop.data.local_database.pizza.PizzaEntity
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.Pizza

fun Banner.toBannerEntity(): BannerEntity {
    return BannerEntity(
        nameBanner, imageBanner
    )
}

fun BannerEntity.toBanner(): Banner {
    return Banner(
        nameBanner, imageBanner
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        nameCategory
    )
}

fun CategoryEntity.toCategory(): Category {
    return Category(
        nameCategory
    )
}

fun Pizza.toPizzaEntity(): PizzaEntity {
    return PizzaEntity(
        nameItem, descriptionItem, costItem, imageItem
    )
}

fun PizzaEntity.toPizza(): Pizza {
    return Pizza(
        nameItem, descriptionItem, costItem, imageItem
    )
}

