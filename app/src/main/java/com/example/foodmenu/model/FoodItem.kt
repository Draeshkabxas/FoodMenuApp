package com.example.foodmenu.model

import android.graphics.drawable.AdaptiveIconDrawable
import androidx.annotation.DrawableRes
import java.util.IdentityHashMap

data class FoodItem(
    val name:String,
    @DrawableRes val imageUrl:Int
    )
