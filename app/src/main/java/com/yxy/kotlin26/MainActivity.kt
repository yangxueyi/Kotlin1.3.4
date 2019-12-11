package com.yxy.kotlin26

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yanzhenjie.permission.AndPermission
import com.yxy.kotlin26.retrift.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.internal.Version
import android.Manifest.permission
import com.luck.picture.lib.PictureSelector
import com.yanzhenjie.permission.Permission
import com.yxy.kotlin26.dialog.TwoBtnDialog
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.FileCallBack
import okhttp3.Call
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.lang.Exception
import java.lang.ref.WeakReference

//import com.yanzhenjie.permission.runtime.Permission


class MainActivity : AppCompatActivity(), LoginContract.LoginView {

    override fun registerSuccess(user: User) {
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show()

    }

    override fun registerError(string: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContext(): Activity {
        return this
    }

    override fun onSuccess(result: Any) {

        Log.e("1111111",Thread.currentThread().name)
        Log.e("1111111",result.toString())
        Toast.makeText(this,(result as User).username,Toast.LENGTH_LONG).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun loginSuccess(user:User) {

        Log.e("1111111",Thread.currentThread().name)
        Log.e("1111111",user.toString())
        Toast.makeText(this,user.username,Toast.LENGTH_LONG).show()

    }

    override fun loginError(string: String) {

        PictureSelector.create(this)
    }

    private val loginPresenter : LoginContract.LoginPresenter by lazy {
        LoginPresenter(this, LoginModle())
    }

//    lateinit var job : Job
//     override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.e("main", Thread.currentThread().toString())
//        job = Job()



//        web_view.loadUrl("https://kefu.easemob.com/webim/im.html?configId=378f4f81-785c-42ed-adf8-d96e8ef87130")




        if (Build.VERSION.SDK_INT  == Build.VERSION_CODES.KITKAT){

        }


        val mutableListOf = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        val removeList : MutableList<Int> = mutableListOf()
        val newList = mutableListOf<Int>()
        var n = 5


        btn.setOnClickListener {
            loginPresenter.registerResult()
//            var removeLast : Int? = null
//            if (mutableListOf.size > 2) {
//                 removeLast = removeList[removeList.size - 1]
//            }
//            if (mutableListOf.contains(removeLast)){
//                val indexOf = mutableListOf.indexOf(removeLast)
//                Log.e("**********indexOf******","${indexOf}")
//                n = (indexOf+1) - removeList.size + 1
//            }
//            mutableListOf.removeAll(removeList)
//            newList.clear()
//            Log.e("****************","${mutableListOf}")
        }

        btn_login.setOnClickListener {
            loginPresenter.loginResult()


            val subList = mutableListOf.subList(n - 1, mutableListOf.size)
            newList.addAll(subList)
            val removeAll = mutableListOf.removeAll(subList)
            if (removeAll){
                mutableListOf.addAll(0,newList)
                n = 0
            }
            var m = 0
            Log.e("****************","${mutableListOf}")
            removeList.clear()
            for (i in 0 until mutableListOf.size ) {
                m++
                if (m == 3){
                    removeList.add(mutableListOf[i])
                    Log.e("*********remove********","${mutableListOf[i]}")
                    m = 0
                }
            }


            





        }



        btn_demo.setOnClickListener {

            runBlocking {
                // 启动一个协程来处理某种传入请求（request）
                val request = launch {
                    repeat(3) { i -> // 启动少量的子作业
                        launch  {
//                            delay((i + 1) * 200L) // 延迟 200 毫秒、400 毫秒、600 毫秒的时间
                            println("Coroutine $i is done")
                        }
                    }
                    println("request: I'm done and I don't explicitly join my children that are still active")
                }
                request.join() // 等待请求的完成，包括其所有子协程
                println("Now processing of the request is complete")
            }

        }

        btn_1.setOnClickListener {
//            startActivity(Intent(this,DemoActivity::class.java))
            getImage()
        }




        btn_two.setOnClickListener {

            val twoBtnDialog = TwoBtnDialog(this)

            twoBtnDialog.setDialogListenter(object : TwoBtnDialog.DialogListenter{
                override fun onSuccess() {
                    Toast.makeText(this@MainActivity,"success",Toast.LENGTH_SHORT).show()

                }

                override fun onError() {
                    Toast.makeText(this@MainActivity,"error",Toast.LENGTH_SHORT).show()
                    twoBtnDialog.dismiss()
                }

            })

            twoBtnDialog.show()

        }





    }


    override fun onResume() {
        super.onResume()
        TwoActivity().setGoMainListenter(object : TwoActivity.GoMainListenter {
            override fun onSuccess(str: String) {
                btn_two.text = str
            }

            override fun onErroe(str: String) {
                btn_demo.text = str
            }
        })
    }

    fun getImage(){
        AndPermission.with(this)
            .runtime()
            .permission(Permission.Group.STORAGE)
            .onGranted({ permissions ->
                // Storage permission are allowed.
                Toast.makeText(this,"权限成功 ",Toast.LENGTH_SHORT).show()
            })
            .onDenied { permissions ->
                // Storage permission are not allowed.
                Toast.makeText(this,"权限拒绝",Toast.LENGTH_SHORT).show()
            }
            .start()
    }





}
