package com.kelway.pizzashop.data.local_database.category

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kelway.pizzashop.domain.model.CategoryType

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey
    val nameCategory: CategoryType
)
