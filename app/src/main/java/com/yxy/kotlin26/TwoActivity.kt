package com.yxy.kotlin26

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_two.*


class TwoActivity : BaseActivity() {

    private  var myGoMainListenter: GoMainListenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)



        go_main.setOnClickListener {
            myGoMainListenter?.onSuccess("success")
        }

        btn_2.setOnClickListener {
            myGoMainListenter?.onErroe("error")
        }

//        tv_1.text =myGoMainListenter?.onSuccess()
//        tv_2.text = myGoMainListenter?.onErroe()

    }

    override fun onResume() {
        super.onResume()

    }


    fun setGoMainListenter(goMainListenter: GoMainListenter){
        this.myGoMainListenter = goMainListenter
    }

    interface GoMainListenter{
        fun onSuccess(str : String)
        fun onErroe(str : String)
    }


}
