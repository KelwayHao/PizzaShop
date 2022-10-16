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

    init {
        initData()
    }

    private fun initData() {
        getBannerData()
        getCategoryData()
        getPizzaData()
    }

    private fun getBannerData() {
        viewModelScope.launch {
            _banner.value = bannerInteractor.getBanner()
        }
    }

    private fun getCategoryData() {
        viewModelScope.launch {
            _category.value = categoryInteractor.getCategory()
        }
    }

    private fun getPizzaData() {
        viewModelScope.launch {
            _pizza.value = pizzaInteractor.getPizza()
        }
    }
}