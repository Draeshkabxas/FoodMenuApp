package com.example.foodmenu.ui.food

import android.graphics.drawable.AdaptiveIconDrawable
import androidx.annotation.DrawableRes
import java.util.IdentityHashMap

data class FoodItem(
    val id:Int,
    val name:String,
    @DrawableRes val imageUrl:Int
    )
