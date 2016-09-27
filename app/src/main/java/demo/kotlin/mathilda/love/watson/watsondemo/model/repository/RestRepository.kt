package demo.kotlin.mathilda.love.watson.watsondemo.model.repository

import demo.kotlin.mathilda.love.watson.watsondemo.model.User
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class RestRepository : Repository {

    @Inject
    constructor() {

    }

    override fun getUser(): User {
        return User("watson", 30)
    }
}