package demo.kotlin.mathilda.love.watson.watsondemo.model

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

/**
 * Created by watson on 16/9/27.
 */
object Utils {

    private var toast: Toast? = null

    fun checkIfHasNetwork(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        val response = networkInfo != null && networkInfo.isConnected
        return response
    }

    fun show(context: Context?, msg: String) {
        if (context == null) {
            return
        }

        if (toast == null) {
            toast = Toast.makeText(context.applicationContext, msg, Toast.LENGTH_SHORT)
        }

        toast?.setText(msg)
        toast?.duration = Toast.LENGTH_SHORT
        toast?.show()
    }

}