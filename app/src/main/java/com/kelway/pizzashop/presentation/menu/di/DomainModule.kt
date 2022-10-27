package com.kelway.pizzashop.presentation.menu.di

import com.kelway.pizzashop.domain.interactor.banner.BannerInteractor
import com.kelway.pizzashop.domain.interactor.banner.BannerInteractorImpl
import com.kelway.pizzashop.domain.interactor.category.CategoryInteractor
import com.kelway.pizzashop.domain.interactor.category.CategoryInteractorImpl
import com.kelway.pizzashop.domain.interactor.pizza.PizzaInteractor
import com.kelway.pizzashop.domain.interactor.pizza.PizzaInteractorImpl
import com.kelway.pizzashop.domain.repository.BannerRepository
import com.kelway.pizzashop.domain.repository.CategoryRepository
import com.kelway.pizzashop.domain.repository.PizzaRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideBannerInteractor(
        bannerRepository: BannerRepository
    ): BannerInteractor {
        return BannerInteractorImpl(bannerRepository)
    }

    @Provides
    fun provideCategoryInteractor(
        categoryRepository: CategoryRepository
    ): CategoryInteractor {
        return CategoryInteractorImpl(categoryRepository)
    }

    @Provides
    fun providePizzaInteractor(
        pizzaRepository: PizzaRepository
    ): PizzaInteractor {
        return PizzaInteractorImpl(pizzaRepository)
    }
}