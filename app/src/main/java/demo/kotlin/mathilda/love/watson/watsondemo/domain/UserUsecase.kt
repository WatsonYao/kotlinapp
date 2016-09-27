package demo.kotlin.mathilda.love.watson.watsondemo.domain

import demo.kotlin.mathilda.love.watson.watsondemo.model.BaseResponse
import demo.kotlin.mathilda.love.watson.watsondemo.model.User
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.Repository
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.RestRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by watson on 16/9/26.
 */
class UserUsecase : Usecase {

    lateinit var repository: RestRepository

    //
    @Inject
    constructor(repository: RestRepository) {
        this.repository = repository
    }

    fun getUser(): User {
        return User("a", 1)
    }

    fun geek(name: String): Observable<BaseResponse> {
        return repository.geek(name)
    }
}