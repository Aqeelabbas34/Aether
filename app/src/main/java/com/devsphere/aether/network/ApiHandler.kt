package com.devsphere.aether.network

import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ApiHandler {

    suspend fun <T> execute(block: suspend () -> T): ApiResult<T> {
        return try {
            val data = block()
            ApiResult.Success(data)
        } catch (e: HttpException) {
            ApiResult.Error(
                message = e.message(),
                code = e.code(),
                throwable = e
            )
        } catch (e: SocketTimeoutException) {
            ApiResult.Error(
                message = "Connection timed out. Please try again.",
                throwable = e
            )
        } catch (e: UnknownHostException) {
            ApiResult.Error(
                message = "No internet connection.",
                throwable = e
            )
        } catch (e: Exception) {
            ApiResult.Error(
                message = e.localizedMessage ?: "Something went wrong.",
                throwable = e
            )
        }
    }
}
