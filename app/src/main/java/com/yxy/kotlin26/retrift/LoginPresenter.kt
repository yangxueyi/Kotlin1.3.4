package com.yxy.kotlin26.retrift

import android.util.Log
import com.yxy.kotlin26.executeResponse1
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/16 16:04
 */
class LoginPresenter(
    private val loginView: LoginContract.LoginView,
    private val loginModle: LoginContract.LoginModle
) :
    LoginContract.LoginPresenter() {
    override fun registerResult() {
        launch {
            try {
                val user = loginModle.getRegisterResponse()
                executeResponse1(
                    user,
                    loginView.getContext(),
                    loginView,
                    success = { loginView.registerSuccess(user.data) })
            } catch (t: Throwable) {
                Log.e("-----888-------", "网络")
            }

        }

    }

    override fun loginResult() {
        launch {
            try {
                val user = loginModle.getLoginResponse()
                executeResponse1(
                    user,
                    loginView.getContext(),
                    loginView,
                    success = { loginView.loginSuccess(user.data) })
            } catch (t: Throwable) {
                Log.e("-----888***-------", "${t.message}")
            }

        }

    }

}