package com.example.openpayexam.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class RetrofitInterceptor : Interceptor {

    /* */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization","Bearer $KEY").build()
        return chain.proceed(request)
    }

    /* */
    private companion object{
        const val KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMmNhMjQ0NTc0N2FiOGVmNDczYzg5YjA1Y2I0NTFjYyIsInN1YiI6IjVlNzNhZjliMzU3YzAwMDAxMTRiZjNhNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Dv2VXg-EkS1UiHGv9VC3guWHO8o1rqFV5aWcJEvaN8A"
    }

}