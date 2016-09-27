package demo.kotlin.mathilda.love.watson.watsondemo.dagger.component

/**
 * Created by watson on 16/9/26.
 */
import dagger.Component
import demo.kotlin.mathilda.love.watson.watsondemo.activity.MainActivity
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForActivity
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.ActivityModule
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.UserInfoModule

/**
 * Created by loop on 14/12/14.
 */
@ForActivity
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(
                ActivityModule::class,
                UserInfoModule::class))
interface UserComponent : ActivityComponent {

    fun inject(activity: MainActivity)
}