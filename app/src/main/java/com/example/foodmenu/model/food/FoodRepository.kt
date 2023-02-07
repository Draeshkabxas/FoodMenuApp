package com.example.foodmenu.model.food

import com.example.foodmenu.ui.food.FoodItem

interface FoodRepository {



    fun getFoodList():List<FoodItem>

    fun getFoodItem(id:Int):FoodItem
}