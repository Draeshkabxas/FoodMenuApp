package com.example.foodmenu.model.settings

import android.content.Context

enum class TextSize(val size:Int){
    Small(20),
    Medium(40),
    Large(52),
}

class SettingsStorageImpl(context:Context):SettingsRepository {

    companion object{
        const val FILE_NAME="name_file"
        const val TEXT_SIZE="text_size"
    }


    private val pref=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)


    override fun setTextSize(sizeText:TextSize){
        pref.edit()
            .putInt(TEXT_SIZE,sizeText.size)
            .apply()
    }
    override fun getTextSize():Int =
        pref.getInt(TEXT_SIZE,30)

}