package com.yxy.kotlin26.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.yxy.kotlin26.R
import kotlinx.android.synthetic.main.two_btn_dialog.*
import java.util.jar.Attributes


/**
 * Created by YangXueYi
 * Time : jajaying on 2019/12/2 09:57
 */

 class TwoBtnDialog(context: Context) : Dialog(context) {


    private var dialogListenter: DialogListenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.two_btn_dialog)

        initView()

    }

    private fun initView() {

        if (dialogListenter != null){
            btn_left.setOnClickListener {
                dialogListenter?.onError()
//                dismiss()
            }

            btn_right.setOnClickListener {
                dialogListenter?.onSuccess()
            }
        }

    }

    fun setDialogListenter(dialogListenter: DialogListenter){
        this.dialogListenter = dialogListenter
    }


    interface DialogListenter{
        fun onSuccess()
        fun onError()
    }

}