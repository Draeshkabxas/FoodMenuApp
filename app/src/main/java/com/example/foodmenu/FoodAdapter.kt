package com.example.foodmenu

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmenu.model.FoodItem

import com.example.foodmenu.databinding.FoodListItemBinding
import com.example.foodmenu.model.SettingsStorage


/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 02,Feb,2023
 */

class FoodAdapter : ListAdapter<FoodItem,RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FoodItem>() {

            override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: FoodListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item,position)
        }
    }

    inner class ViewHolder(private val itemBinding: FoodListItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(item:FoodItem,position: Int){

                var settingsStorage= SettingsStorage(itemBinding.container.context)
                itemBinding.foodItemName.text = item.name
                itemBinding.foodItemName.textSize = settingsStorage.getTextSize().toFloat()
                itemBinding.foodItemImage.setImageResource(item.imageUrl)
            }
    }
}