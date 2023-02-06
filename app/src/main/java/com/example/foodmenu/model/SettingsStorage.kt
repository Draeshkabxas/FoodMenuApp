package com.example.foodmenu.model

import android.content.Context

enum class TextSize(val size:Int){
    Small(20),
    Medium(40),
    Large(52),
}

class SettingsStorage(context:Context) {

    companion object{
        const val FILE_NAME="name_file"
        const val TEXT_SIZE="text_size"
    }


    private val pref=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)


    fun setTextSize(sizeText:TextSize){
        pref.edit()
            .putInt(TEXT_SIZE,sizeText.size)
            .apply()
    }
    fun getTextSize():Int =
        pref.getInt(TEXT_SIZE,30)

}