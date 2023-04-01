package com.ljs.ljs_calcu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var ljs_resultTextView: TextView
    private var ljs_operand1: Double = 0.0
    private var ljs_operand2: Double = 0.0
    private var ljs_operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ljs_resultTextView = findViewById(R.id.ljs_result)

        //번호 변수 선언
        val button0: Button = findViewById(R.id.ljs_0)
        val button1: Button = findViewById(R.id.ljs_1)
        val button2: Button = findViewById(R.id.ljs_2)
        val button3: Button = findViewById(R.id.ljs_3)
        val button4: Button = findViewById(R.id.ljs_4)
        val button5: Button = findViewById(R.id.ljs_5)
        val button6: Button = findViewById(R.id.ljs_6)
        val button7: Button = findViewById(R.id.ljs_7)
        val button8: Button = findViewById(R.id.ljs_8)
        val button9: Button = findViewById(R.id.ljs_9)
        val buttonDot: Button = findViewById(R.id.ljs_dot)

        //연산 변수 선언
        val buttonPlus: Button = findViewById(R.id.ljs_plus)
        val buttonMinus: Button = findViewById(R.id.ljs_minus)
        val buttonMultiply: Button = findViewById(R.id.ljs_mul)
        val buttonDivide: Button = findViewById(R.id.ljs_div)
        val buttonEqual: Button = findViewById(R.id.ljs_equal)
        val buttonClear: Button = findViewById(R.id.ljs_ac)

        val listener = View.OnClickListener { v ->
            val button = v as Button
            when (button.id) {
                R.id.ljs_0 -> numberClicked("0")
                R.id.ljs_1 -> numberClicked("1")
                R.id.ljs_2 -> numberClicked("2")
                R.id.ljs_3 -> numberClicked("3")
                R.id.ljs_4 -> numberClicked("4")
                R.id.ljs_5 -> numberClicked("5")
                R.id.ljs_6 -> numberClicked("6")
                R.id.ljs_7 -> numberClicked("7")
                R.id.ljs_8 -> numberClicked("8")
                R.id.ljs_9 -> numberClicked("9")
                R.id.ljs_dot -> numberClicked(".")
                R.id.ljs_plus -> operationClicked("+")
                R.id.ljs_minus -> operationClicked("-")
                R.id.ljs_mul -> operationClicked("*")
                R.id.ljs_div -> operationClicked("/")
                R.id.ljs_equal -> equalClicked()
                R.id.ljs_ac -> clearClicked()
            }
        }

        //번호 클릭 리스너
        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        //연산 클릭 리스너
        buttonPlus.setOnClickListener(listener)
        buttonMinus.setOnClickListener(listener)
        buttonMultiply.setOnClickListener(listener)
        buttonDivide.setOnClickListener(listener)
        buttonEqual.setOnClickListener(listener)
        buttonClear.setOnClickListener(listener)
    }

    private fun numberClicked(number: String) {
        val currentValue = ljs_resultTextView.text.toString()
        if(currentValue != null){

        }
        ljs_resultTextView.text = currentValue + number
    }

    @SuppressLint("SetTextI18n")
    private fun operationClicked(op: String) {
        ljs_operand1 = ljs_resultTextView.text.toString().toDouble()
        ljs_operation = op
        ljs_resultTextView.text = op
    }

    private fun equalClicked() {
        ljs_operand2 = ljs_resultTextView.text.toString().toDouble()
        val result: Double = when (ljs_operation) {
            "+" -> ljs_operand1 + ljs_operand2
            "-" -> ljs_operand1 - ljs_operand2
            "*" -> ljs_operand1 * ljs_operand2
            "/" -> ljs_operand1 / ljs_operand2
            else -> 0.0
        }
        ljs_resultTextView.text = result.toString()
    }

    private fun clearClicked() {
        ljs_resultTextView.text = ""
        ljs_operand1 = 0.0
        ljs_operand2 = 0.0
        ljs_operation = ""
    }
}


