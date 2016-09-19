package demo.kotlin.mathilda.love.watson.watsondemo

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import rx.Single
import rx.SingleSubscriber
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            view ->
            test3()
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun test() {
        Single.just(2).subscribe(object : SingleSubscriber<Int>() {
            override fun onSuccess(value: Int?) {
                // value = 3
                MyLoggerK.create().i("value->" + value)
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
                MyLoggerK.create().i("value->" + value)
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
                        MyLoggerK.create().i("o->" + o)
                    }
                })
    }
}
