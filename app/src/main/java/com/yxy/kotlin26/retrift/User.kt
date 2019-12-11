package com.yxy.kotlin26.retrift

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/16 14:13
 */
  class User (val collectIds: List<Int>,
                  val email: String,
                  val icon: String,
                  val id: Int,
                  val password: String,
                  val type: Int,
                  val username: String){
    override fun toString(): String {
        return "User(collectIds=$collectIds, email='$email', icon='$icon', id=$id, password='$password', type=$type, username='$username')"
    }
}