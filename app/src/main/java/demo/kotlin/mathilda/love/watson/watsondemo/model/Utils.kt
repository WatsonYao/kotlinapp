package demo.kotlin.mathilda.love.watson.watsondemo.model

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by watson on 16/9/27.
 */
object Utils {

    fun checkIfHasNetwork(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        val response = networkInfo != null && networkInfo.isConnected
        return response
    }
}