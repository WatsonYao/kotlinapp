package demo.kotlin.mathilda.love.watson.watsondemo.dagger.module

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForApplication
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.Repository
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.RestRepository
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by watson on 16/9/26.
 */
@Module
class AndroidModule(private val application: Application) {

    /**
     * Allow the application context to be injected but require that it be annotated with [ ][ForApplication] to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    @ForApplication
    fun provideRepository(): Repository {
        return RestRepository()
    }


    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String {
        return "something"
    }

    @Provides
    @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String {
        return "somethingElse"
    }

}