package com.example.foodmenu.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.foodmenu.R
import com.example.foodmenu.databinding.FragmentFoodBinding
import com.example.foodmenu.model.settings.SettingsStorageImpl

class FoodFragment : Fragment(R.layout.fragment_food) {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    private val foodViewModel by viewModels<FoodViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)
        val settings=SettingsStorageImpl(requireContext())

        val foodAdapter = FoodAdapter(settingsStorage =settings){
           val action = FoodFragmentDirections.actionFoodFragmentToFoodDetailsFragment2(it)
            view.findNavController().navigate(action)
        }
        binding.foodListRV.adapter = foodAdapter
        foodViewModel.foodList.observe(viewLifecycleOwner) { foods->
            foodAdapter.submitList(foods)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}