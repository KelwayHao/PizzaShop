package com.kelway.pizzashop.data.local_database.pizza

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza")
data class PizzaEntity(
    @PrimaryKey
    val nameItem: String,
    @ColumnInfo(name = "descriptionItem")
    val descriptionItem: String,
    @ColumnInfo(name = "costItem")
    val costItem: Int,
    @ColumnInfo(name = "imageItem")
    val imageItem: Int
)