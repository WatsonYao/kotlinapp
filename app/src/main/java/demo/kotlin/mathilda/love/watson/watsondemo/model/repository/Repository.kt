package demo.kotlin.mathilda.love.watson.watsondemo.model.repository

import demo.kotlin.mathilda.love.watson.watsondemo.model.BaseResponse
import demo.kotlin.mathilda.love.watson.watsondemo.model.User
import rx.Observable

/**
 * Created by watson on 16/9/26.
 */
interface Repository {

    fun getUser(): User

    fun geek(name: String): Observable<BaseResponse>
}

