package com.furkan.core.common.networking

import retrofit2.Response
abstract class BaseDataSource {
    /**
     * Executes a network call and returns the result wrapped in a Resource.
     * This method handles the response of the network call executed by the `call` lambda function.
     * It ensures that the network response is successful and the response body is not null.

     * @param T The type parameter representing the type of data the API response holds.
     * @param call A suspend lambda function that executes the network call and returns a Response<T>.
     * @return A Resource<T> indicating success with data or error with a message.
     */
     suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            val errorBody = response.errorBody().toString()
            return error("${response.code()} - $errorBody")
        } catch (err: Exception) {
            return error("${err.localizedMessage} - ${err.message}")
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network error: $message")
    }
}