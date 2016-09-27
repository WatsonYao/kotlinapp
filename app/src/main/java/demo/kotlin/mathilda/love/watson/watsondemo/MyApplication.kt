package demo.kotlin.mathilda.love.watson.watsondemo

import android.app.Application
import android.location.LocationManager
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.ApplicationComponent
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.DaggerApplicationComponent
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.AndroidModule
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class MyApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: ApplicationComponent
    }


    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().androidModule(AndroidModule(this)).build()
        graph.inject(this)

    }
}