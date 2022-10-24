package com.kelway.pizzashop.presentation.menu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.FragmentMenuBinding
import com.kelway.pizzashop.domain.model.CategoryType
import com.kelway.pizzashop.presentation.PizzaShopApplication
import com.kelway.pizzashop.presentation.connection_network.ConnectivityObserver
import com.kelway.pizzashop.presentation.connection_network.NetworkConnectivityObserver
import com.kelway.pizzashop.presentation.connection_network.StatusConnection
import com.kelway.pizzashop.presentation.listener.SelectingCategoryClickListener
import com.kelway.pizzashop.presentation.menu.adapter.CategoryAdapter
import com.kelway.pizzashop.presentation.menu.adapter.MenuAdapter
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class MenuFragment : Fragment(R.layout.fragment_menu) {

    @Inject
    lateinit var menuViewModel: MenuViewModel

    private val binding by viewBinding<FragmentMenuBinding>()
    private val bannerAdapter by lazy { MenuAdapter() }
    private val categoryAdapter by lazy { CategoryAdapter(selectingCategoryListener) }
    private val pizzaAdapter by lazy { MenuAdapter() }
    private lateinit var connectivityObserver: ConnectivityObserver

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
        connectivityObserver = NetworkConnectivityObserver(requireContext().applicationContext)
        checkConnectionInternet(connectivityObserver)
        initAdapter()
    }

    private fun checkConnectionInternet(connectivityObserver: ConnectivityObserver) {
        connectivityObserver.observe().onEach { status ->
            when (status) {
                StatusConnection.Unavailable -> {
                    Log.e("Error", "Unavailable")
                    menuViewModel.offlineMode()
                }
                StatusConnection.Losing -> {
                    Log.e("Error", "Losing")
                    menuViewModel.offlineMode()
                }
                StatusConnection.Available -> {
                    Log.e("Error", "Available")
                    menuViewModel.onlineMode()
                }
                StatusConnection.Lost -> {
                    Log.e("Error", "Lost")
                    menuViewModel.offlineMode()
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun initAdapter() {
        binding.categoryRecycler.adapter = categoryAdapter
        binding.bannerRecycler.adapter = bannerAdapter
        binding.itemRecycler.adapter = pizzaAdapter

        initObserve()
    }

    private fun initObserve() {
        menuViewModel.banner.observe(viewLifecycleOwner) { listBanner ->
            bannerAdapter.submitList(listBanner)
        }
        menuViewModel.category.observe(viewLifecycleOwner) { listCategory ->
            categoryAdapter.submitList(listCategory)
        }
    }
}