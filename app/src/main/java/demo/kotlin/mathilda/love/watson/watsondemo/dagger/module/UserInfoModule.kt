package demo.kotlin.mathilda.love.watson.watsondemo.dagger.module

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForActivity
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.ForApplication
import demo.kotlin.mathilda.love.watson.watsondemo.domain.UserUsecase
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.Repository
import demo.kotlin.mathilda.love.watson.watsondemo.model.repository.RestRepository
import rx.Scheduler
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by watson on 16/9/26.
 */
@Module
class UserInfoModule() {

    @Provides
    @ForActivity
    fun provideUserInfoUsecase(repository: Repository,
                               @Named("ui_thread") uiThread: Scheduler,
                               @Named("executor_thread") executorThread: Scheduler): UserUsecase {
        return UserUsecase(repository, uiThread, executorThread)
    }
}