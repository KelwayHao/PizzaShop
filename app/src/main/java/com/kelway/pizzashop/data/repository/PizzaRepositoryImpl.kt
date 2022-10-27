package com.kelway.pizzashop.data.repository

import com.kelway.pizzashop.data.local_database.pizza.PizzaDao
import com.kelway.pizzashop.data.network_data.PizzaDatabase
import com.kelway.pizzashop.domain.model.Pizza
import com.kelway.pizzashop.domain.repository.PizzaRepository
import com.kelway.pizzashop.utils.toPizza
import com.kelway.pizzashop.utils.toPizzaEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val pizzaDao: PizzaDao
) : PizzaRepository {
    override suspend fun getPizzaDatabase(): List<Pizza> {
        return withContext(Dispatchers.IO) {
            return@withContext PizzaDatabase.listPizza
        }
    }

    override suspend fun getCachePizzaData(): List<Pizza> {
        return withContext(Dispatchers.IO) {
            return@withContext pizzaDao.getAllPizzaDao().map { pizzaEntity ->
                pizzaEntity.toPizza()
            }
        }
    }

    override suspend fun saveCachePizzaData(pizza: Pizza) {
        withContext(Dispatchers.IO) {
            if (!pizzaDao.getAllPizzaDao().contains(pizza.toPizzaEntity())) {
                pizzaDao.savePizzaDao(pizza.toPizzaEntity())
            }
        }
    }
}