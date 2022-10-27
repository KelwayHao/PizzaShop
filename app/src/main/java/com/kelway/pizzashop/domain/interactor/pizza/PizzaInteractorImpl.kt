package com.kelway.pizzashop.domain.interactor.pizza

import com.kelway.pizzashop.domain.model.Pizza
import com.kelway.pizzashop.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaInteractorImpl @Inject constructor(private val pizzaRepository: PizzaRepository) :
    PizzaInteractor {
    override suspend fun getPizza(): List<Pizza> {
        return pizzaRepository.getPizzaDatabase()
    }

    override suspend fun getAllCacheCategory(): List<Pizza> {
        return pizzaRepository.getCachePizzaData()
    }

    override suspend fun saveCacheCategory(pizza: Pizza) {
        pizzaRepository.saveCachePizzaData(pizza)
    }
}