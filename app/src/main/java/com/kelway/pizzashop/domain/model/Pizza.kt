package com.kelway.pizzashop.domain.model

data class Pizza(
    val nameItem: String,
    val descriptionItem: String,
    val costItem: Int,
    val imageItem: Int
): MenuItem()
