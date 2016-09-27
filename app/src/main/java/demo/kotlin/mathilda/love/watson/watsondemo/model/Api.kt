package demo.kotlin.mathilda.love.watson.watsondemo.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by watson on 16/9/27.
 */
interface Api {

    @GET("/users/{username}")
    fun geek(@Path("username") username: String): Observable<Geek>
}