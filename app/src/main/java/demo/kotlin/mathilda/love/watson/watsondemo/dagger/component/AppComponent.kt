package demo.kotlin.mathilda.love.watson.watsondemo.dagger.component

/**
 * Created by watson on 16/9/26.
 */
import dagger.Component
import demo.kotlin.mathilda.love.watson.watsondemo.MyApplication
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.AndroidModule
import demo.kotlin.mathilda.love.watson.watsondemo.model.ApiSp
import javax.inject.Singleton

/**
 * Created by loop on 14/12/14.
 */
@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface AppComponent {

    fun app(): MyApplication

    fun apiSp(): ApiSp
}