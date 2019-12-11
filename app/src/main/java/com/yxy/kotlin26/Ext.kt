package com.yxy.kotlin26

import android.app.Activity
import android.content.Context
import android.net.sip.SipErrorCode
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.yxy.kotlin26.retrift.BaseView
import com.yxy.kotlin26.retrift.LoginContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException

/**
 * Created by
 */

/*suspend fun executeResponse(
    response: WanResponse<User>, successBlock: suspend CoroutineScope.() -> Unit,
    errorBlock: suspend CoroutineScope.() -> Unit) {
    coroutineScope {
        if (response.errorCode == -1) errorBlock()
        else successBlock()
    }
}*/


suspend fun executeResponse1(
    response: WanResponse<Any>, context: Activity,childView: BaseView,success: (data : WanResponse<Any>) -> Unit) {

    coroutineScope {
        if (response.errorCode != -1) {
            success(response)
        }else {
            Toast.makeText(context,response.errorMsg+"****",Toast.LENGTH_SHORT).show()
        }
    }

}