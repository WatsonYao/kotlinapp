package demo.kotlin.mathilda.love.watson.watsondemo.model.repository

import demo.kotlin.mathilda.love.watson.watsondemo.model.Geek
import rx.Observable

/**
 * Created by watson on 16/9/26.
 */
interface Repository {

    fun geek(name: String): Observable<Geek>
}

