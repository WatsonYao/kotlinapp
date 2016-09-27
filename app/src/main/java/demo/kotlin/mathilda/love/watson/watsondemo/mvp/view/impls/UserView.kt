package demo.kotlin.mathilda.love.watson.watsondemo.mvp.view.impls

import demo.kotlin.mathilda.love.watson.watsondemo.model.Geek
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.view.BaseView

/**
 * Created by watson on 16/9/26.
 */

interface UserView : BaseView {
    fun showUser(user: Geek);
}