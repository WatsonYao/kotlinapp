package demo.kotlin.mathilda.love.watson.watsondemo

import android.app.Application
import com.facebook.stetho.Stetho
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.AppComponent
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.DaggerAppComponent
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.AndroidModule

/**
 * Created by watson on 16/9/26.
 */
class MyApplication : Application() {

    companion object {
        @JvmStatic lateinit var graph: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().androidModule(AndroidModule(this)).build()

        initDebug()
    }

    private fun initDebug() {
        try {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}