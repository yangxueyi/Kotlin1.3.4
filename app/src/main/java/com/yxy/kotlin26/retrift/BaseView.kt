package com.yxy.kotlin26.retrift

import android.app.Activity

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/18 13:40
 */
interface BaseView {
     fun onSuccess(result: Any)
     fun onError(message: String)
    fun  getContext() : Activity
}