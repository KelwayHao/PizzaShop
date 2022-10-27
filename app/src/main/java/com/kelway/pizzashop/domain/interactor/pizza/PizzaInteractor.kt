package com.kelway.pizzashop.domain.interactor.pizza

import com.kelway.pizzashop.domain.model.Pizza

interface PizzaInteractor {
    suspend fun getPizza(): List<Pizza>
    suspend fun getAllCacheCategory(): List<Pizza>
    suspend fun saveCacheCategory(pizza: Pizza)
}