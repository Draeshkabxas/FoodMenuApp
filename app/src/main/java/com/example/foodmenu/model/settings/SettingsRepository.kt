package com.example.foodmenu.model.settings

import org.w3c.dom.Text

interface SettingsRepository {
    fun setTextSize(textSize:TextSize)

    fun getTextSize():Int
}