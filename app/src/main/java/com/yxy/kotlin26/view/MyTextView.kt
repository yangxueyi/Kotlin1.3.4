package com.yxy.kotlin26.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.yxy.kotlin26.R

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/12/5 14:47
 */
class MyTextView : TextView {

    var paint : Paint? = Paint()

    constructor(context: Context?) : super(context)
    constructor(context: Context? , attr: AttributeSet) : super(context,attr)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    init {
        //设置画笔颜色
        paint?.color = Color.CYAN
        //设置它的填充方法，用的多的是FILL 和 STORKE
        paint?.style = Paint.Style.FILL
    }


    override fun onDraw(canvas: Canvas?) {
        //绘制方形背景
        canvas?.drawRect(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat(), paint!!)
        super.onDraw(canvas)
    }

}