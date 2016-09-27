package demo.kotlin.mathilda.love.watson.watsondemo.domain

import demo.kotlin.mathilda.love.watson.watsondemo.model.Geek
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.Repository
import rx.Observable
import rx.Scheduler
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by watson on 16/9/26.
 */
class UserUsecase : Usecase {

    val uiThread: Scheduler
    val executorThread: Scheduler

    lateinit var repository: Repository

    //
    @Inject
    constructor(repository: Repository,
                @Named("ui_thread") uiThread: Scheduler,
                @Named("executor_thread") executorThread: Scheduler) {
        this.repository = repository
        this.uiThread = uiThread
        this.executorThread = executorThread
    }

    fun geek(name: String): Observable<Geek> {
        return repository.geek(name).observeOn(uiThread).subscribeOn(executorThread)
    }
}