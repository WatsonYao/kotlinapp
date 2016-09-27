package demo.kotlin.mathilda.love.watson.watsondemo.activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import demo.kotlin.mathilda.love.watson.watsondemo.R
import demo.kotlin.mathilda.love.watson.watsondemo.WLog
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.AppComponent
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.component.DaggerUserComponent
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.ActivityModule
import demo.kotlin.mathilda.love.watson.watsondemo.dagger.module.UserInfoModule
import demo.kotlin.mathilda.love.watson.watsondemo.model.EditTextNullError
import demo.kotlin.mathilda.love.watson.watsondemo.model.Geek
import demo.kotlin.mathilda.love.watson.watsondemo.model.appErrors.AppError
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.presenter.impls.UserPresenter
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.view.bindView
import demo.kotlin.mathilda.love.watson.watsondemo.mvp.view.impls.UserView
import rx.Single
import rx.SingleSubscriber
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity(), UserView {

    override fun loading(show: Boolean) {
        loading.visibility = if (show) View.VISIBLE else View.GONE
    }

    @Inject
    lateinit var presenter: UserPresenter

    val info: TextView by bindView(R.id.info)
    val name: EditText by bindView(R.id.name)
    val fab: FloatingActionButton by bindView(R.id.fab)
    val toolbar: Toolbar by bindView(R.id.toolbar)
    val loading: ProgressBar by bindView(R.id.loading)

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerUserComponent.builder()
                .appComponent(appComponent)
                .activityModule(ActivityModule(this))
                .userInfoModule(UserInfoModule())
                .build().inject(this)
    }

    override fun showUser(geek: Geek) {
        info.text = geek.toString()
    }

    override fun showError(e: AppError) {
        showBaseError(e)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        presenter.bindView(this)

        fab.setOnClickListener {
            view ->
            if (!TextUtils.isEmpty(name.text.toString().trim())) {
                presenter.getGeek(name.text.toString().trim())
            } else {
                showError(EditTextNullError())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun test() {
        Single.just(2).subscribe(object : SingleSubscriber<Int>() {
            override fun onSuccess(value: Int?) {
                // value = 3
                WLog.p().i("value->" + value)
            }

            override fun onError(error: Throwable) {
            }
        })
    }

    fun test2() {
        Single.just(3).compose(object : Single.Transformer<Int, String> {
            override fun call(integerSingle: Single<Int>): Single<String> {
                return integerSingle.map(object : Func1<Int, String> {
                    override fun call(integer: Int?): String {
                        return (integer!! + 2).toString()
                    }
                })
            }
        }).subscribe(object : SingleSubscriber<String>() {
            override fun onSuccess(value: String) {
                // value = 5
                WLog.p().i("value->" + value)
            }

            override fun onError(error: Throwable) {
            }
        })
    }

    fun test3() {

        // 常见的示例，这是一个异步操作
        Single.create(object : Single.OnSubscribe<Int> {
            override fun call(singleSubscriber: SingleSubscriber<in Int>) {
                // 这里被指定在IO线程
                singleSubscriber.onSuccess(3)
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Int>() {
                    override fun onCompleted() {
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onNext(o: Int?) {
                        // o = 3
                        WLog.p().i("o->" + o)
                    }
                })
    }
}
