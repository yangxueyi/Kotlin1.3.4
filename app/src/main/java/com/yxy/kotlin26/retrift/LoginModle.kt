package com.yxy.kotlin26.retrift

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/16 16:02
 */
class LoginModle : LoginContract.LoginModle() {
    override suspend fun getRegisterResponse() =
        withContext(Dispatchers.IO) {
            val register = MyHelper.getService("https://www.wanandroid.com", MyService::class.java)
                .register("i99kpm", "Aa123456", "Aa123456")
            register
        }

    override suspend fun getLoginResponse() =
        withContext(Dispatchers.IO) {
            val login = MyHelper.getService("https://www.wanandroid.com", MyService::class.java)
                .login("i99kpm", "Aa123456")
            Log.e("-----------",login.toString())
            login
        }


}