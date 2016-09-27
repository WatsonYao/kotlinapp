package demo.kotlin.mathilda.love.watson.watsondemo.dagger.component

/**
 * Created by watson on 16/9/26.
 */
import dagger.Component
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForActivity
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.ActivityModule

/**
 * Created by loop on 14/12/14.
 */
@ForActivity
@Component(
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
}