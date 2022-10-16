package com.kelway.pizzashop.domain.interactor.banner

import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.repository.BannerRepository
import javax.inject.Inject

class BannerInteractorImpl @Inject constructor(private val bannerRepository: BannerRepository) :
    BannerInteractor {
    override suspend fun getBanner(): List<Banner> {
        return bannerRepository.getBannerDatabase()
    }

}