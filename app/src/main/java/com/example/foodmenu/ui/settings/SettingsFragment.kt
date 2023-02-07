package com.example.foodmenu.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.foodmenu.R
import com.example.foodmenu.databinding.FragmentSettingsBinding
import com.example.foodmenu.model.settings.SettingsStorageImpl
import com.example.foodmenu.model.settings.TextSize

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        val settings = SettingsStorageImpl(requireContext())

        binding.apply {
            when(settings.getTextSize()){
                TextSize.Small.size -> smallRB.isChecked = true
                TextSize.Medium.size -> mediumRB.isChecked = true
                TextSize.Large.size -> largeRB.isChecked = true
                else -> smallRB.isChecked = true
            }
            radioG.setOnCheckedChangeListener { radioGroup, i ->
                when(radioGroup.checkedRadioButtonId){
                    R.id.smallRB -> settings.setTextSize(TextSize.Small)
                    R.id.mediumRB -> settings.setTextSize(TextSize.Medium)
                    R.id.largeRB -> settings.setTextSize(TextSize.Large)
                }
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}