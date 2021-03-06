package demo.kotlin.mathilda.love.watson.watsondemo.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import demo.kotlin.mathilda.love.watson.watsondemo.MyApplication
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.AppComponent
import demo.kotlin.mathilda.love.watson.watsondemo.model.Utils
import demo.kotlin.mathilda.love.watson.watsondemo.model.appErrors.AppError

/**
 * Created by watson on 16/9/26.
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityComponent(MyApplication.graph)
    }

    protected abstract fun setupActivityComponent(appComponent: AppComponent)


    fun showBaseError(appError: AppError) {
        Utils.show(this, appError.getName())
    }
}