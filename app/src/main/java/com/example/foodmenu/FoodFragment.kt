package com.example.foodmenu

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.foodmenu.databinding.FragmentFoodBinding
import com.example.foodmenu.model.FoodItem

class FoodFragment : Fragment(R.layout.fragment_food) {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)

        val foods = mutableListOf<FoodItem>(
            FoodItem("Apple",R.drawable.apple),
            FoodItem("Burger",R.drawable.hamburger),
            FoodItem("Pizza",R.drawable.pizza),
            FoodItem("Rice",R.drawable.rice),
            FoodItem("Spaghetti",R.drawable.pot),
            FoodItem("Banana",R.drawable.banana),
            FoodItem("Cookie",R.drawable.cookie),
        )
        val foodAdapter = FoodAdapter()
        binding.foodListRV.adapter = foodAdapter
        foodAdapter.submitList(foods)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}