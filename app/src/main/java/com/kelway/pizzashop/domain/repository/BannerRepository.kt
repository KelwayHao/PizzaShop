package com.kelway.pizzashop.domain.repository

import com.kelway.pizzashop.data.local_database.banner.BannerEntity
import com.kelway.pizzashop.domain.model.Banner

interface BannerRepository {
    suspend fun getBannerDatabase(): List<Banner>
    suspend fun getCacheBannerData(): List<Banner>
    suspend fun saveCacheBannerData(banner: Banner)
}