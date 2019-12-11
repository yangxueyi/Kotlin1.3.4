package com.yxy.kotlin26.retrift

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/16 14:15
 */
object MyHelper {

    private const val CONNECT_TIMEOUT =20L
    private const val READ_TIMEOUT = 20L
    private const val WRITE_TIMEOUT = 20L

    /**
     *获取 Retrofit
     */
    private fun create(url: String): Retrofit {
        //获取OkHttpClient
        val okHttpClient = OkHttpClient().newBuilder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取时间
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//写入超时时间
//            if (AppConstants.DEBUG) {
//                //显示日志
//                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//            } else {
//                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
//            }
//
//            addInterceptor(ResponseInterceptor)//得到响应的cookie
//            addInterceptor(RequestInterceptor)//设置请求的Cookie
//            addInterceptor(NetworkInterceptor)

        }
        return RetrofitBuild(url,
            okHttpClient.build(),
            GsonConverterFactory.create())//gson工厂
            .retrofit


    }
    /**
     *获取serviceApi
     */
    fun <T> getService(url: String, service: Class<T>): T = create(url).create(service)


    /**
     * 创建 retrofit build
     */
    class RetrofitBuild(url: String, client: OkHttpClient,
                        gsonFactory: GsonConverterFactory
                       ) {

        //获取retrofit
        val retrofit = Retrofit.Builder().apply {
            baseUrl(url)
            client(client)
            addConverterFactory(gsonFactory)
//            addCallAdapterFactory(coroutineCallAdapterFactory)
        }.build()

    }
}