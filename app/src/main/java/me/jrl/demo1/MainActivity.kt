package me.jrl.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //保存抽奖名单
    var names = listOf<String>("张三","李四","老王")
    //记录当前索引
    var index = 0
    //定时器
    lateinit var timer: Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){

        //设置默认显示第一个人
        mTextView.text = names[index]
        //给按钮添加点击事件
        mButton.setOnClickListener {
            //判断标题是Start还是Stop
            if (mButton.text.toString() == "Start"){
                mButton.text = "Stop"
                //创建定时器
                timer = Timer()
                //分配定时任务
                timer.schedule(object: TimerTask(){
                    override fun run() {
                        index = if (index+1 > names.size-1) 0 else index++
                        //取出对应名字
                        mTextView.text = names[index]
                    }
                },0,100)
            }else{
                mButton.text = "Start"
                timer.cancel()
            }
        }
    }
}