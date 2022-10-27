package com.kelway.pizzashop.data.local_database.banner

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BannerDao {
    @Query("SELECT * FROM banner")
    fun getAllBannerDao(): List<BannerEntity>

    @Insert
    suspend fun saveBannerDao(bannerEntity: BannerEntity)
}