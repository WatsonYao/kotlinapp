package demo.kotlin.mathilda.love.watson.watsondemo.model

import demo.kotlin.mathilda.love.watson.watsondemo.model.appErrors.AppError


const val END_POINT = "https://api.github.com"


data class User(val name: String, val age: Int)

class NetNullError : AppError {
    override fun getName(): String {
        return "no wifi"
    }

    override fun getType(): Int {
        return 404;
    }
}

data class BaseResponse(val message: String)


