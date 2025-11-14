package com.example.mycatsapplication.network

import android.util.Log
import com.example.mycatsapplication.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    private val tag = "cats"
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val httpUrl: HttpUrl = original.url
        val url: HttpUrl = httpUrl.newBuilder()
            .build()
        val request: Request = original.newBuilder().addHeader("x-api-key", BuildConfig.CAT_API_KEY)
            .url(url)
            .build()
        val response = chain.proceed(request)
        Log.d(tag, "request url = ${response.request.url} ")
        return response
    }
}