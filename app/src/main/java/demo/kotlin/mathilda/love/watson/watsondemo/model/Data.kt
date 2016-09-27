package demo.kotlin.mathilda.love.watson.watsondemo.model

import demo.kotlin.mathilda.love.watson.watsondemo.model.appErrors.AppError


const val END_POINT = "https://api.github.com"


class NetNullError : AppError {
    override fun getName(): String {
        return "no wifi"
    }

    override fun getType(): Int {
        return 404;
    }
}

class EditTextNullError : AppError {
    override fun getName(): String {
        return "不能为空"
    }

    override fun getType(): Int {
        return 1010;
    }
}

//{
//    "login": "WatsonYao",
//    "id": 10070520,
//    "avatar_url": "https://avatars.githubusercontent.com/u/10070520?v=3",
//    "gravatar_id": "",
//    "url": "https://api.github.com/users/WatsonYao",
//    "html_url": "https://github.com/WatsonYao",
//    "followers_url": "https://api.github.com/users/WatsonYao/followers",
//    "following_url": "https://api.github.com/users/WatsonYao/following{/other_user}",
//    "gists_url": "https://api.github.com/users/WatsonYao/gists{/gist_id}",
//    "starred_url": "https://api.github.com/users/WatsonYao/starred{/owner}{/repo}",
//    "subscriptions_url": "https://api.github.com/users/WatsonYao/subscriptions",
//    "organizations_url": "https://api.github.com/users/WatsonYao/orgs",
//    "repos_url": "https://api.github.com/users/WatsonYao/repos",
//    "events_url": "https://api.github.com/users/WatsonYao/events{/privacy}",
//    "received_events_url": "https://api.github.com/users/WatsonYao/received_events",
//    "type": "User",
//    "site_admin": false,
//    "name": "Yao Yuan",
//    "company": "iRanShao",
//    "blog": "https://github.com/WatsonYao/note/wiki",
//    "location": null,
//    "email": "yaoyuan131617@gmail.com",
//    "hireable": null,
//    "bio": null,
//    "public_repos": 15,
//    "public_gists": 3,
//    "followers": 21,
//    "following": 90,
//    "created_at": "2014-12-04T05:34:03Z",
//    "updated_at": "2016-09-20T01:46:36Z"
//}
data class Geek(
        val message: String,
        val login: String,
        val id: String,
        val avatar_url: String,
        val gravatar_id: String,
        val url: String,
        val html_url: String,
        val followers_url: String,
        val following_url: String,
        val gists_url: String,
        val starred_url: String,
        val subscriptions_url: String,
        val organizations_url: String,
        val repos_url: String,
        val events_url: String,
        val received_events_url: String,
        val type: String,
        val site_admin: String,
        val name: String,
        val company: String,
        val blog: String,
        val location: String,
        val email: String,
        val hireable: String,
        val bio: String,
        val public_repos: String,
        val public_gists: String,
        val followers: String,
        val following: String,
        val created_at: String,
        val updated_at: String
)




