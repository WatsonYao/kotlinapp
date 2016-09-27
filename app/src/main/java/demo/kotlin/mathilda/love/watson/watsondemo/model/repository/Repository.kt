package demo.kotlin.mathilda.love.watson.watsondemo.model.repository

import demo.kotlin.mathilda.love.watson.watsondemo.model.User

/**
 * Created by watson on 16/9/26.
 */
interface Repository {
    fun getUser(): User
}

