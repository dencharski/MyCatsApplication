package com.example.mycatsapplication.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response


class LoggingInterceptor() : Interceptor {
    private val tag = "cats"
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val response: Response = chain.proceed(request)
        Log.d(tag, "response = ${response.code} ")
        Log.d(tag, "response.request headers.  ${response.request.headers} ")
        if (!response.isSuccessful) {
            when (response.code) {
                100 -> {
                    Log.d(tag, "code 100. Часть запроса принята. Продолжайте")
                }

                200 -> {
                    Log.d(tag, "code 200. Ок ")
                }

                400 -> {
                    Log.d(tag, "code 400. Плохой запрос.")
                }

                401 -> {
                    Log.d(tag, "code 401. Неавторизованный запрос.")
                }

                403 -> {
                    Log.d(tag, "code 403. Доступ запрещен.")
                }

                404 -> {
                    Log.d(tag, "code 404. Не найдено.")
                }

                500 -> {
                    Log.d(tag, "code 500. Ошибка на сервере.")
                }

                else -> {
                    Log.d(tag, "code else. response = ${response.code} ")
                }

            }
        }
        return response
    }
}