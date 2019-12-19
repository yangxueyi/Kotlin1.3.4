package com.yxy.kotlin26

import android.app.Application
import android.util.Log

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/29 11:42
 */
class MyAppli : Application(),MyState{


    override fun onCreate() {
        super.onCreate()

        networkState(this)

    }

}
