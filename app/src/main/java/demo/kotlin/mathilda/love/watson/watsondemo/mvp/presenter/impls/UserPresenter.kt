package demo.kotlin.mathilda.love.watson.watsondemo.mvp.presenter.impls

import demo.kotlin.mathilda.love.watson.watsondemo.WLog
import demo.kotlin.mathilda.love.watson.watsondemo.domain.UserUsecase
import demo.kotlin.mathilda.love.watson.watsondemo.model.Geek
import demo.kotlin.mathilda.love.watson.watsondemo.model.NetNullError
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.presenter.BasePresenter
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.view.impls.UserView
import rx.Subscription
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class UserPresenter : BasePresenter {

    val usecase: UserUsecase
    lateinit var userView: UserView
    private var subscription: Subscription? = null

    @Inject
    constructor(userUsecase: UserUsecase) {
        this.usecase = userUsecase
    }

    fun bindView(view: UserView) {
        userView = view
    }

    fun getGeek(name: String) {
        userView.loading(true)
        subscription = usecase.geek(name)
                .subscribe(
                        { this.geekResponse(it) },
                        { this.showErrorView(it) }
                )
    }

    private fun showErrorView(it: Throwable?) {
        userView.loading(false)
        it?.printStackTrace()
        userView.showError(NetNullError())
        WLog.p().i("")
    }

    private fun geekResponse(it: Geek?) {
        userView.loading(false)
        WLog.p().i("-->" + it)
        if (it != null) {
            userView.showUser(it)
        }
    }

}