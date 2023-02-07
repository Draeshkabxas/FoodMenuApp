package com.example.foodmenu.model.food

import com.example.foodmenu.R
import com.example.foodmenu.ui.food.FoodItem

class FoodRepositoryImpl: FoodRepository {
    private val _foods = mutableListOf<FoodItem>(
        FoodItem(0,"Apple", R.drawable.apple),
        FoodItem(1,"Burger", R.drawable.hamburger),
        FoodItem(2,"Pizza", R.drawable.pizza),
        FoodItem(3,"Rice", R.drawable.rice),
        FoodItem(4,"Spaghetti", R.drawable.pot),
        FoodItem(5,"Banana", R.drawable.banana),
        FoodItem(6,"Cookie", R.drawable.cookie),
    )
    val food:List<FoodItem> get() = _foods

    override fun getFoodList(): List<FoodItem> = food

    override fun getFoodItem(id: Int): FoodItem = food[id]
}