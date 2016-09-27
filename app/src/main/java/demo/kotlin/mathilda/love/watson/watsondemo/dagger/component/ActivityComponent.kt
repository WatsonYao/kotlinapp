package demo.kotlin.mathilda.love.watson.watsondemo.dagger.component

/**
 * Created by watson on 16/9/26.
 */
import android.content.Context
import dagger.Component
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForActivity
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.ActivityModule

/**
 * Created by loop on 14/12/14.
 */
@ForActivity
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun context(): Context
}