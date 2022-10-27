package com.kelway.pizzashop.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.pizzashop.domain.interactor.banner.BannerInteractor
import com.kelway.pizzashop.domain.interactor.category.CategoryInteractor
import com.kelway.pizzashop.domain.interactor.pizza.PizzaInteractor
import com.kelway.pizzashop.domain.model.Banner
import com.kelway.pizzashop.domain.model.Category
import com.kelway.pizzashop.domain.model.Pizza
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val bannerInteractor: BannerInteractor,
    private val categoryInteractor: CategoryInteractor,
    private val pizzaInteractor: PizzaInteractor
) : ViewModel() {

    private val _banner = MutableLiveData<List<Banner>>()
    val banner: LiveData<List<Banner>> get() = _banner

    private val _category = MutableLiveData<List<Category>>()
    val category: LiveData<List<Category>> get() = _category

    private val _pizza = MutableLiveData<List<Pizza>>()
    val pizza: LiveData<List<Pizza>> get() = _pizza

    fun offlineMode() {
        getCacheBannerData()
        getCacheCategoryData()
        getCachePizzaData()
    }

    fun onlineMode() {
        getBannerData()
        getCategoryData()
        getPizzaData()
    }

    private fun getBannerData() {
        viewModelScope.launch {
            _banner.value = bannerInteractor.getBanner()
            bannerInteractor.getBanner().map { banner ->
                bannerInteractor.saveCacheBanner(banner)
            }
        }
    }

    private fun getCategoryData() {
        viewModelScope.launch {
            val categoryData = categoryInteractor.getCategory()
            _category.value = categoryData
            categoryData.map { category ->
                categoryInteractor.saveCacheCategory(category)
            }
        }
    }

    private fun getPizzaData() {
        viewModelScope.launch {
            _pizza.value = pizzaInteractor.getPizza()
            pizzaInteractor.getPizza().map { pizza ->
                pizzaInteractor.saveCacheCategory(pizza)
            }
        }
    }

    private fun getCacheBannerData() {
        viewModelScope.launch {
            _banner.value = bannerInteractor.getAllCacheBanner()
        }
    }

    private fun getCacheCategoryData() {
        viewModelScope.launch {
            _category.value = categoryInteractor.getAllCacheCategory()
        }
    }

    private fun getCachePizzaData() {
        viewModelScope.launch {
            _pizza.value = pizzaInteractor.getAllCacheCategory()
        }
    }
}