package com.kelway.pizzashop.data.repository

import com.kelway.pizzashop.data.network_data.PizzaDatabase
import com.kelway.pizzashop.domain.model.Pizza
import com.kelway.pizzashop.domain.repository.PizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PizzaRepositoryImpl() : PizzaRepository {
    override suspend fun getPizzaDatabase(): List<Pizza> {
        return withContext(Dispatchers.IO) {
            return@withContext PizzaDatabase.listPizza
        }
    }
}