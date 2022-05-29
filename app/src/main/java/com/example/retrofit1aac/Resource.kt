package com.example.retrofit1aac

data class Resource<out T>( val data : T?, val status : Status, val message : String? ){

    companion object{

        fun <T> Loading(data : T?) : Resource<T> = Resource(data = data, status = Status.LOADING, message = null)

        fun <T> Success(data : T?) : Resource<T> = Resource(data = data, status = Status.SUCCESS, message = null)

        fun <T> Error(data : T?, message: String?) : Resource<T> = Resource(
            data = data,
            status = Status.ERROR,
            message = message
        )
    }

}