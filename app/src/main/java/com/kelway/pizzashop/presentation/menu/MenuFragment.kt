package com.kelway.pizzashop.presentation.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.FragmentMenuBinding
import com.kelway.pizzashop.domain.model.CategoryType
import com.kelway.pizzashop.presentation.PizzaShopApplication
import com.kelway.pizzashop.presentation.listener.SelectingCategoryClickListener
import com.kelway.pizzashop.presentation.menu.adapter.CategoryAdapter
import com.kelway.pizzashop.presentation.menu.adapter.MenuAdapter
import javax.inject.Inject

class MenuFragment : Fragment(R.layout.fragment_menu) {

    @Inject
    lateinit var menuViewModel: MenuViewModel

    private val binding by viewBinding<FragmentMenuBinding>()
    private val bannerAdapter by lazy { MenuAdapter() }
    private val categoryAdapter by lazy { CategoryAdapter(selectingCategoryListener) }
    private val pizzaAdapter by lazy { MenuAdapter() }

    private val selectingCategoryListener = object : SelectingCategoryClickListener {
        override fun selectCategory(categoryType: CategoryType) {
            when (categoryType) {
                CategoryType.PIZZA -> {
                    menuViewModel.pizza.observe(viewLifecycleOwner) { listPizza ->
                        pizzaAdapter.submitList(listPizza)
                    }
                }
                CategoryType.COMBO -> pizzaAdapter.submitList(listOf())
                CategoryType.DESSERTS -> pizzaAdapter.submitList(listOf())
                CategoryType.DRINKS -> pizzaAdapter.submitList(listOf())
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        PizzaShopApplication.appComponent?.inject(this)
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.categoryRecycler.adapter = categoryAdapter
        binding.bannerRecycler.adapter = bannerAdapter
        binding.itemRecycler.adapter = pizzaAdapter

        menuViewModel.banner.observe(viewLifecycleOwner) { listBanner ->
            bannerAdapter.submitList(listBanner)
        }
        menuViewModel.category.observe(viewLifecycleOwner) { listCategory ->
            categoryAdapter.submitList(listCategory)
        }

    }
}