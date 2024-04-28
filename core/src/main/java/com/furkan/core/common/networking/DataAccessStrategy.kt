package com.furkan.core.common.networking

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Performs a network operation asynchronously and emits the result as a Flow.
 * This function wraps the network call in a Flow that handles loading, success, and error states.

 * @param T The type of data the network response will hold.
 * @param call A suspend lambda function that executes the network operation and returns a Resource<T>.
 * @return A Flow<Resource<T>> that emits the current state of the network operation (loading, success, or error).
 */
fun <T> performNetworkOperationFlow(call: suspend () -> Resource<T>): Flow<Resource<T>> = flow {
    emit(Resource.loading(null))
    val response = call()
    emit(response)
}.catch { e ->
    emit(Resource.error("Error occurred: ${e.localizedMessage}", null))
}