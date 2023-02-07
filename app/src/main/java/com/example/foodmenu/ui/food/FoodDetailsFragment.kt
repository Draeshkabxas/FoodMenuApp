package com.example.foodmenu.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.foodmenu.R
import com.example.foodmenu.databinding.FragmentFoodDetailsBinding

class FoodDetailsFragment : Fragment(R.layout.fragment_food_details) {
    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: FoodDetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<FoodViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodDetailsBinding.bind(view)

        binding.apply {
            var foodItem = viewModel.getFoodItem(args.Id)
            foodName.text = foodItem.name
            foodImage.setImageResource(foodItem.imageUrl)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}