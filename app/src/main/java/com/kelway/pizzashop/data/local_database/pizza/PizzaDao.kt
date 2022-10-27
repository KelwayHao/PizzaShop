package com.kelway.pizzashop.data.local_database.pizza

import androidx.room.*

@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizza")
    fun getAllPizzaDao(): List<PizzaEntity>

    @Insert
    suspend fun savePizzaDao(pizzaEntity: PizzaEntity)
}