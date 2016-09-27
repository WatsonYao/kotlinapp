package demo.kotlin.mathilda.love.watson.watsondemo.mvp.presenter.impls

import android.view.View
import demo.kotlin.mathilda.love.watson.watsondemo.WLog
import demo.kotlin.mathilda.love.watson.watsondemo.model.User
import demo.kotlin.mathilda.love.watson.watsondemo.domain.UserUsecase
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.presenter.BasePresenter
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.view.impls.UserView
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class UserPresenter : BasePresenter {

    val userUsecase: UserUsecase
    lateinit var userView: UserView

    @Inject
    constructor(userUsecase: UserUsecase) {
        this.userUsecase = userUsecase
    }

    fun bindView(view: UserView) {
        userView = view
    }

    fun getUser() {
        WLog.p().i("")
        userView.showUser(userUsecase.getUser())
    }

}