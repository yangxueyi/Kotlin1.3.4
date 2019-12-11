package com.yxy.kotlin26.retrift

class BaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T) {
    override fun toString(): String {
        return "BaseResponse(errorCode=$errorCode, errorMsg='$errorMsg', data=$data)"
    }
}