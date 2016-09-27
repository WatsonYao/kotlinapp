package demo.kotlin.mathilda.love.watson.watsondemo.domain

import demo.kotlin.mathilda.love.watson.watsondemo.model.User
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.Repository
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class UserUsecase : Usecase {

    //    lateinit var repository: Repository
//
    @Inject
    constructor() {

    }

    fun getUser(): User {
        return User("a", 1)
    }
}