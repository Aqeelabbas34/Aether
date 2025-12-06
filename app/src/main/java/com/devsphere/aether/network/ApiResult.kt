package com.devsphere.aether.network

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(
        val message: String,
        val code: Int? = null,
        val throwable: Throwable? = null
    ) : ApiResult<Nothing>()
}
