package com.kelway.pizzashop.data.network_data

import com.kelway.pizzashop.R
import com.kelway.pizzashop.domain.model.Pizza

class PizzaDatabase() {
    companion object {
        val listPizza = listOf(
            Pizza(
                "Ветчина и грибы",
                "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                345,
                R.drawable.ham_and_mushrooms
            ),
            Pizza(
                "Баварские колбаски",
                "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
                345,
                R.drawable.bavarian_sausages
            ),
            Pizza(
                "Флорентийская",
                "Cоус из протертых томатов, Моцарелла, ветчина, свинина, соус Ранч, лук порей, маринованные опята, приправа к пицце, масло чесночное",
                345,
                R.drawable.florentiyskaya
            ),
            Pizza(
                "Народная",
                "Cоус из протертых томатов, Моцарелла, ветчина, шампиньоны, маринованные огурцы, приправа к пицце, масло чесночное",
                345,
                R.drawable.narodnaya
            )
        )
    }
}