package com.kelway.pizzashop.data.local_database.banner

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banner")
data class BannerEntity(
    @PrimaryKey
    val nameBanner: String,
    @ColumnInfo(name = "imageBanner")
    val imageBanner: Int
)
