package com.yxy.kotlin26.retrift

import com.yxy.kotlin26.WanResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/16 16:04
 */
class LoginContract {

//    interface LoginCallback{
//        fun loginSuccess(user: WanResponse<User>)
//        fun loginError(string: String)
//    }

    abstract class LoginModle{
       abstract suspend fun getRegisterResponse() : WanResponse<User>
        abstract suspend fun getLoginResponse() : WanResponse<User>
    }

    interface LoginView : BaseView{
        fun loginSuccess(user:User)
        fun loginError(string: String)
        fun registerSuccess(user: User)
        fun registerError(string: String)
    }

    abstract class LoginPresenter : CoroutineScope{

         var job : Job = Job()
        override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

        abstract fun loginResult()
        abstract fun registerResult()
    }

}