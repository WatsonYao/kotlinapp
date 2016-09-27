package demo.kotlin.mathilda.love.watson.watsondemo.mvp.view

import demo.kotlin.mathilda.love.watson.watsondemo.model.appErrors.AppError

/**
 * Created by watson on 16/9/26.
 */
interface BaseView {
    fun showError(e: AppError)
}