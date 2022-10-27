package com.kelway.pizzashop.data.repository

import com.kelway.pizzashop.data.local_database.banner.BannerDao
import com.kelway.pizzashop.data.network_data.BannerDatabase
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.repository.BannerRepository
import com.kelway.pizzashop.utils.toBanner
import com.kelway.pizzashop.utils.toBannerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
    private val bannerDao: BannerDao
) : BannerRepository {
    override suspend fun getBannerDatabase(): List<Banner> {
        return withContext(Dispatchers.IO) {
            return@withContext BannerDatabase.listBanner
        }
    }

    override suspend fun getCacheBannerData(): List<Banner> {
        return withContext(Dispatchers.IO) {
            return@withContext bannerDao.getAllBannerDao().map { bannerEntity ->
                bannerEntity.toBanner()
            }
        }
    }

    override suspend fun saveCacheBannerData(banner: Banner) {
        withContext(Dispatchers.IO) {
            if (!bannerDao.getAllBannerDao().contains(banner.toBannerEntity())) {
                bannerDao.saveBannerDao(banner.toBannerEntity())
            }
        }
    }
}