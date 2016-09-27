package demo.kotlin.mathilda.love.watson.watsondemo.model.repository

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import demo.kotlin.mathilda.love.watson.watsondemo.model.*
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class RestRepository : Repository {

    val api: Api
//    val apiSp: ApiSp

    @Inject
    constructor(apiSp: ApiSp) {
//        this.apiSp = apiSp

        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        // TODO: 16/7/11 上线关闭
        val client = OkHttpClient.Builder()
                .addInterceptor(logginInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val request = chain.request().newBuilder()
                                .addHeader("Accept", "application/vnd.github.v3+json")
                                .build()
                        return chain.proceed(request)
                    }

                })
//                .addInterceptor(provideOfflineCacheIntercepter())
//                .addNetworkInterceptor(provideCacheInterceptor())
                .cache(provideCache()).build()


        val retrofit = Retrofit.Builder().baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()


        api = retrofit.create(Api::class.java)
    }

//    fun getContext() = apiSp.getContext()

//    fun provideOfflineCacheIntercepter(): Interceptor {
//        return Interceptor { chain ->
//            var request = chain.request()
//            if (!Utils.checkIfHasNetwork(getContext())) {
//                val cacheControl = CacheControl.Builder().maxStale(7, TimeUnit.DAYS).build()
//
//                request = request.newBuilder().cacheControl(cacheControl).build()
//            }
//            chain.proceed(request)
//        }
//    }
//
//    fun provideCacheInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val response = chain.proceed(chain.request())
//
//            var cacheControl: CacheControl? = null
//
//            if (!Utils.checkIfHasNetwork(getContext())) {
//                cacheControl = CacheControl.Builder().maxAge(2, TimeUnit.MINUTES).build()
//            } else {
//                cacheControl = CacheControl.Builder().maxAge(0, TimeUnit.MINUTES).build()
//            }
//
//
//            response.newBuilder().header("Cache-Control", cacheControl!!.toString()).build()
//        }
//    }

    private fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache = Cache(File("/data/data/com.qiangfeng.iranshao/", "http-cache"), 10 * 1024 * 1024.toLong()) // 10 MB
        } catch (e: Exception) {
            //            MyLogger.yLog().i("");
        }

        return cache
    }

    override fun getUser(): User {
        return User("watson", 30)
    }


    override fun geek(name: String): Observable<BaseResponse> {
        return api.geek(name)
    }

}