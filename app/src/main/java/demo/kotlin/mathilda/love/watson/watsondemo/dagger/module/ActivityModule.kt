package demo.kotlin.mathilda.love.watson.watsondemo.dagger.module

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForActivity
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForApplication
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by watson on 16/9/26.
 */
@Module
class ActivityModule(private val context: Context) {

    @Provides
    @ForActivity
    fun provideActivityContext(): Context {
        return context
    }
}