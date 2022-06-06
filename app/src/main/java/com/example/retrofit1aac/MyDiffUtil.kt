package com.example.retrofit1aac

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(private val oldList : List<Model>, private val newList: List<Model>) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{

            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }

            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }

            oldList[oldItemPosition].phone != newList[newItemPosition].phone -> {
                false
            }

            oldList[oldItemPosition].address != newList[newItemPosition].address -> {
                false
            }

            else -> true

        }
    }

}