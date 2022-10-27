package com.kelway.pizzashop.domain.repository

import com.kelway.pizzashop.domain.model.Pizza

interface PizzaRepository {
    suspend fun getPizzaDatabase(): List<Pizza>
    suspend fun getCachePizzaData(): List<Pizza>
    suspend fun saveCachePizzaData(pizza: Pizza)
}