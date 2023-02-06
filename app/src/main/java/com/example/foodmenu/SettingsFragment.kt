package com.example.foodmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodmenu.databinding.FragmentSettingsBinding
import com.example.foodmenu.model.SettingsStorage
import com.example.foodmenu.model.TextSize

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        var settingsStorage=SettingsStorage(requireContext())
        binding.apply {
            when(settingsStorage.getTextSize()){
                TextSize.Small.size -> smallRB.isChecked = true
                TextSize.Medium.size -> mediumRB.isChecked = true
                TextSize.Large.size -> largeRB.isChecked = true
                else -> smallRB.isChecked = true
            }
            radioG.setOnCheckedChangeListener { radioGroup, i ->
                when(radioGroup.checkedRadioButtonId){
                    R.id.smallRB -> settingsStorage.setTextSize(TextSize.Small)
                    R.id.mediumRB-> settingsStorage.setTextSize(TextSize.Medium)
                    R.id.largeRB -> settingsStorage.setTextSize(TextSize.Large)
                }
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}