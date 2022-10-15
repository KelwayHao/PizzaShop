package com.kelway.pizzashop.presentation.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.FragmentMenuBinding
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.CategoryType
import com.kelway.pizzashop.domain.model.Pizza
import com.kelway.pizzashop.presentation.PizzaShopApplication
import com.kelway.pizzashop.presentation.menu.adapter.MenuAdapter

class MenuFragment : Fragment(R.layout.fragment_menu) {

    /*@Inject
    lateinit var menuViewModel: MenuViewModel*/
    private val binding by viewBinding<FragmentMenuBinding>()
    private val bannerAdapter by lazy { MenuAdapter() }
    private val categoryAdapter by lazy { MenuAdapter() }
    private val pizzaAdapter by lazy { MenuAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        PizzaShopApplication.appComponent?.inject(this)
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.categoryRecycler.adapter = categoryAdapter
        categoryAdapter.submitList(
            listOf(
                Category(CategoryType.PIZZA),
                Category(CategoryType.COMBO),
                Category(CategoryType.DESSERTS),
                Category(CategoryType.DRINKS)
            )
        )
        binding.bannerRecycler.adapter = bannerAdapter
        bannerAdapter.submitList(
            listOf(
                Banner("", R.drawable.banner1),
                Banner("", R.drawable.banner2)
            )
        )
        binding.itemRecycler.adapter = pizzaAdapter
        pizzaAdapter.submitList(
            listOf(
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
                ),
            )
        )
    }
}