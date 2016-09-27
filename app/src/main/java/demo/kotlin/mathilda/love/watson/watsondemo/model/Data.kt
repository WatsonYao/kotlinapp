package demo.kotlin.mathilda.love.watson.watsondemo.model

import demo.kotlin.mathilda.love.watson.watsondemo.model.appErrors.AppError

data class User(val name: String, val age: Int)

class NetNullError : AppError {
    override fun getName(): String {
        return "no wifi"
    }

    override fun getType(): Int {
        return 404;
    }

}
