package com.kelway.pizzashop.data.repository

import com.kelway.pizzashop.data.data.BannerDatabase
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.repository.BannerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BannerRepositoryImpl() : BannerRepository {
    override suspend fun getBannerDatabase(): List<Banner> {
        return withContext(Dispatchers.IO) {
            return@withContext BannerDatabase.listBanner
        }
    }
}