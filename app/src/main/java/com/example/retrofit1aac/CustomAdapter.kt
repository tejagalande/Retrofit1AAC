package com.example.retrofit1aac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit1aac.databinding.ItemsBinding

class CustomAdapter(var data : ArrayList<Model>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    lateinit var binding: ItemsBinding

    class CustomViewHolder(private val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun set(model: Model){

            binding.textViewName.text = model.name
            binding.textViewAddress.text = model.address
            binding.textViewPhone.text= model.phone.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        binding = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.set(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun retrive(data: ArrayList<Model> ){
        this.data.apply {
            clear()
            addAll(data)
        }
    }


    fun setData(newList : List<Model>){

        val diffUtil = MyDiffUtil(data, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        data = newList as ArrayList<Model>
        diffUtilResult.dispatchUpdatesTo(this)

    }
}


