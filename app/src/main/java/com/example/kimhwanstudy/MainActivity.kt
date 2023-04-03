package com.example.kimhwanstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textView : TextView
    var num1 : Int = 0
    var num2 : Int = 0
    var checkable = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView.setText("")
        val btn1 : Button = findViewById<Button>(R.id.button_1)
        val btn2 : Button = findViewById<Button>(R.id.button_2)
        val btn3 : Button = findViewById<Button>(R.id.button_3)
        val btn4 : Button = findViewById<Button>(R.id.button_4)
        val btn5 : Button = findViewById<Button>(R.id.button_5)
        val btn6 : Button = findViewById<Button>(R.id.button_6)
        val btn7 : Button = findViewById<Button>(R.id.button_7)
        val btn8 : Button = findViewById<Button>(R.id.button_8)
        val btn9 : Button = findViewById<Button>(R.id.button_9)
        val btn0 : Button = findViewById<Button>(R.id.button_0)
        val btn_plus : Button = findViewById<Button>(R.id.button_plus)
        val btn_minus : Button = findViewById<Button>(R.id.button_minus)
        val btn_mul : Button = findViewById<Button>(R.id.button_multiple)
        val btn_div : Button = findViewById<Button>(R.id.button_div)
        val btn_equal : Button = findViewById<Button>(R.id.button_equal)
        val btn_clear : Button = findViewById<Button>(R.id.button_clear)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btn_plus.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
        btn_div.setOnClickListener(this)
        btn_mul.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_clear.setOnClickListener(this)


    }

    //버튼 누르면 숫자 추가
    override fun onClick(view : View?){
        if(view != null){
            when(view.id){
                R.id.button_0 -> {
                    clear()
                    textView.append("0")
                }
                R.id.button_1 -> {
                    clear()
                    textView.append("1")
                }
                R.id.button_2 -> {
                    clear()
                    textView.append("2")
                }
                R.id.button_3 -> {
                    clear()
                    textView.append("3")
                }
                R.id.button_4 -> {
                    clear()
                    textView.append("4")
                }
                R.id.button_5 -> {
                    clear()
                    textView.append("5")
                }
                R.id.button_6 -> {
                    clear()
                    textView.append("6")
                }
                R.id.button_7 -> {
                    clear()
                    textView.append("7")
                }
                R.id.button_8 -> {
                    clear()
                    textView.append("8")
                }
                R.id.button_9 -> {
                    clear()
                    textView.append("9")
                }
                R.id.button_plus -> {
                    textView.append("+")
                                    }
                R.id.button_minus -> {
                    textView.append("-")
                                    }
                R.id.button_multiple -> {
                    textView.append("*")
                                    }
                R.id.button_div -> {
                    textView.append("/")
                                    }
                R.id.button_equal -> {
                    clear()
                    textView.append("=")
                    caculate()
                }
                R.id.button_clear -> textView.setText("")
            }
        }
    }

    fun plus(num1 : String, num2 : String) : Int{
        var number2 = num2
        if(num2.equals("")){
            number2 = "0"
        }
        return num1.toInt() + number2.toInt()
    }
    fun minus(num1 : String, num2 : String) : Int{
        var number2 = num2
        if(num2.equals("")){
            number2 = "0"
        }
        return num1.toInt() - number2.toInt()
    }
    fun mul(num1 : String, num2 : String) : Int{
        var number2 = num2
        if(num2.equals("")){
            number2 = "1"
        }
        return num1.toInt() * number2.toInt()
    }
    fun div(num1 : String, num2 : String) : Float{
        var number2 = num2
        if(num2.equals("")){
            number2 = "1"
        }
        var number1 = num1.toFloat()
        return number1 / number2.toFloat()
    }

    //계산기. 계산 기호 앞뒤로 숫자를 받아서 계산하는 기능
    fun caculate(){
        if(textView.text.contains("+")){
            var num1 : String
            var num2 : String
            num1 = textView.text.split("+")[0]
            num2 = textView.text.split("+")[1].replace("=","")
            textView.append(plus(num1,num2).toString())
        }
        else if(textView.text.contains("-")){
            var num1 : String
            var num2 : String
            num1 = textView.text.split("-")[0]
            num2 = textView.text.split("-")[1].replace("=","")
            textView.append(minus(num1,num2).toString())
        }
        else if(textView.text.contains("*")){
            var num1 : String
            var num2 : String
            num1 = textView.text.split("*")[0]
            num2 = textView.text.split("*")[1].replace("=","")
            textView.append(mul(num1,num2).toString())
        }
        if(textView.text.contains("/")){
            var num1 : String
            var num2 : String
            num1 = textView.text.split("/")[0]
            num2 = textView.text.split("/")[1].replace("=","")
            textView.append(div(num1,num2).toString())
        }
    }

    //계산이 끝나고 숫자 누르면 새로 입력됨
    fun clear(){
        if(textView.text.contains("=")){
            textView.setText("")
            textView.setText("")
        }
    }

}