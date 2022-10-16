package com.kelway.pizzashop.domain.interactor.banner

import com.kelway.pizzashop.domain.model.Banner

interface BannerInteractor {
    suspend fun getBanner(): List<Banner>
}