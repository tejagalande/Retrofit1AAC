package com.example.retrofit1aac

import android.util.Log
import android.view.Display
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

 //   using mutable livedata
//    val theaterList = MutableLiveData<List<Model>>()
//    fun getDetails(){
//        viewModelScope.launch {
//            Log.i("data",mainRepository.getData().body()?.toString()!!)
//            theaterList.postValue(mainRepository.getData().body())
//        }
//    }

    fun getData() = liveData(Dispatchers.IO) {
        emit(Resource.Loading(data = null))

        try {
            if (mainRepository.getData().isSuccessful){
                emit(Resource.Success(data = mainRepository.getData().body()))
            }

        }
        catch (e : Exception){
            emit(Resource.Error(data = null,

                message = e.localizedMessage
                ))
        }
    }
}