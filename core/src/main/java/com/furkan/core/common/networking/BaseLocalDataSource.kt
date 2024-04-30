package com.furkan.core.common.networking

abstract class BaseLocalDataSource {

    /**
     * Executes a suspend function call and returns the result wrapped in a Resource object.
     * This method handles the exceptions that might be thrown during the function execution
     * and wraps the result into either a success or error state accordingly.
     *
     * @param call A suspend function that returns a generic type T result which will be executed.
     * @return Returns a Resource object containing either:
     *         - Success with data of type T if the call succeeds,
     *         - Error with an exception message if an error occurs during the function execution.
     */
    protected suspend fun <T> getResult(call: suspend () -> T): Resource<T> {
        return try {
            Resource.success(call())
        } catch (e: Exception) {
            Resource.error(e.localizedMessage?:"Unknown error occurred")
        }
    }
}