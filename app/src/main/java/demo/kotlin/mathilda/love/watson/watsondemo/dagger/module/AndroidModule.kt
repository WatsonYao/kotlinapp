package demo.kotlin.mathilda.love.watson.watsondemo.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import demo.kotlin.mathilda.love.watson.watsondemo.MyApplication
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForApplication
import demo.kotlin.mathilda.love.watson.watsondemo.model.ApiSp
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.Repository
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.RestRepository
import javax.inject.Singleton

/**
 * Created by watson on 16/9/26.
 */
@Module
class AndroidModule(private val application: MyApplication) {


    @Provides
    @Singleton
    fun provideMyApplicaiton(): MyApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApiSp(): ApiSp {
        return ApiSp()
    }

    @Provides
    @Singleton
    fun provideDataRepository(restRepository: RestRepository): RestRepository {
        return restRepository
    }

//    @Provides
//    @Singleton
//    @Named("something")
//    fun provideSomething(): String {
//        return "something"
//    }
//
//    @Provides
//    @Singleton
//    @Named("somethingElse")
//    fun provideSomethingElse(): String {
//        return "somethingElse"
//    }

}