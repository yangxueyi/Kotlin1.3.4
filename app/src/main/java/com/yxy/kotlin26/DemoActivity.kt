package com.yxy.kotlin26

import android.graphics.*
import android.graphics.Color.GRAY
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_demo.*

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/10/18 14:28
 */
class DemoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)





        //设置图片灰化
        val cm = ColorMatrix()
        cm.setSaturation(0F)// 设置饱和度
        val grayColorFilter = ColorMatrixColorFilter(cm)
        iv.colorFilter = grayColorFilter // 如果想恢复彩色显示，设置为null即可





        //改变颜色
//        iv.setColorFilter(Color.GREEN)



//        iv.setImageBitmap(toGrayScale())


    }

    /**
     * 图片去色,返回灰度图片
     * @param bmpOriginal 传入的图片
     * @return 去色后的图片
     */
    fun toGrayScale(): Bitmap {
        val bmpOriginal = BitmapFactory.decodeResource(resources, R.mipmap.splash_5)
        val width: Int = bmpOriginal.width
        val height: Int = bmpOriginal.height
        val bmpGrayscale = Bitmap.createBitmap(
            width, height,
            Bitmap.Config.RGB_565
        )
        val c = Canvas(bmpGrayscale)
        val paint = Paint()
        val cm = ColorMatrix()
        cm.setSaturation(0f)
        val f = ColorMatrixColorFilter(cm)
        paint.colorFilter = f
        c.drawBitmap(bmpOriginal, 0f, 0f, paint)
        return bmpGrayscale
    }

}