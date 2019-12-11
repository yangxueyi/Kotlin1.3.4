package com.yxy.kotlin26

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/16 14:13
 */
 class WanResponse<out T> (val errorCode: Int, val errorMsg: String,val data : T){
    override fun toString(): String {
        return "WanResponse(errorCode=$errorCode, errorMsg='$errorMsg', data=$data)"
    }
}