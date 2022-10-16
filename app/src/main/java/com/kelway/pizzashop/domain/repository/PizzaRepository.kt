package com.kelway.pizzashop.domain.repository

import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.Pizza

interface PizzaRepository {
    suspend fun getPizzaDatabase(): List<Pizza>
}