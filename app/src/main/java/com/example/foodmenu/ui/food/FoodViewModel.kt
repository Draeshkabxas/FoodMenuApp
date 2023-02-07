package com.example.foodmenu.ui.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodmenu.model.food.FoodRepository
import com.example.foodmenu.model.food.FoodRepositoryImpl

class FoodViewModel:ViewModel() {
    private var _foodList: MutableLiveData<List<FoodItem>> = MutableLiveData(emptyList())
    val foodList: LiveData<List<FoodItem>> get() = _foodList
    private val repository: FoodRepository = FoodRepositoryImpl()

    init {
        getListOfFood()
    }

    fun getListOfFood() {
        _foodList.value = repository.getFoodList()
    }

    fun getFoodItem(id:Int) =
        repository.getFoodItem(id)


}