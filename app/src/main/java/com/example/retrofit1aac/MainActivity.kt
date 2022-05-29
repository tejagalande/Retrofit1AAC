package com.example.retrofit1aac

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit1aac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CustomAdapter
    private lateinit var viewModel: MainViewModel
    var listData = arrayListOf<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        setUpViewMode()
        initializeViews()
        getData()

        binding.swipeLayout.setOnRefreshListener {

            binding.swipeLayout.setColorSchemeColors(Color.BLUE)
            getData()

        }
    }

    private fun setUpViewMode() {

        val factory = MainViewModelFactory(RetrofitService.api)
        viewModel = ViewModelProvider(
            this,
            factory
        )[MainViewModel::class.java]
    }

    private fun initializeViews() {

        binding.recyclerViewData.layoutManager = LinearLayoutManager(this)
        adapter = CustomAdapter(listData)

        binding.recyclerViewData.adapter = adapter

    }

    private fun getData(){

        // using mutable livedata
//        viewModel.getDetails()
//
//
//        viewModel.theaterList.observe(this){
//
//            adapter.apply {
//                listData.clear()
//                listData.addAll(it)
//                notifyDataSetChanged()
//            }
//
//        }

        viewModel.getData().observe(this){ resource ->

            resource?.let {
                when(it.status){

                    Status.LOADING -> {
                        Toast.makeText(applicationContext,"Wait",Toast.LENGTH_SHORT).show()
                    }

                    Status.SUCCESS -> {

                        it.data?.let { data ->
                            binding.swipeLayout.isRefreshing = false
                            setData(data)

                        }
                    }

                    Status.ERROR -> {
                        binding.swipeLayout.isRefreshing = false
                        Toast.makeText(applicationContext,"Error occurred",Toast.LENGTH_SHORT).show()
                        adapter.apply {

                            listData.clear()
                            notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

    private fun setData(data: List<Model>) {
        adapter.apply {
            //setData(data)

            listData.clear()
            listData.addAll(data)
            notifyDataSetChanged()
        }
    }
}