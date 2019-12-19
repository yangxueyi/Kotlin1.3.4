package com.yxy.kotlin26

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.net.NetworkInfo
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelStore
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.trello.rxlifecycle3.LifecycleProvider
import com.trello.rxlifecycle3.RxLifecycle.bindUntilEvent
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/12/18 16:16
 */
interface MyState {




    fun networkState(application: Application){
        val myMap = mutableMapOf<String,Boolean>().withDefault { true }

        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{

            @SuppressLint("CheckResult")
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

                    ReactiveNetwork
                        .observeNetworkConnectivity(activity.applicationContext)
                        .subscribeOn(Schedulers.io())
                        .bindUntilEvent(activity as LifecycleProvider<ActivityEvent>, ActivityEvent.DESTROY)//release util onDestroy
                        .compose { it ->
                            //compose operate ObservableSource，not consumer callBack
                            it.flatMap { Observable.just((it.available() && it.state() == NetworkInfo.State.CONNECTED)) }
                        }
                        .filter { !it &&  myMap[activity.javaClass.simpleName] ?: true  }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { connectivity ->
                            Log.e("111111111",connectivity.toString())
                            // do something
                        }



            }

            override fun onActivityResumed(activity: Activity) {
                myMap[activity.javaClass.simpleName] = true
            }

            override fun onActivityPaused(activity: Activity) {
                myMap[activity.javaClass.simpleName] = false
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }


        })


    }

}