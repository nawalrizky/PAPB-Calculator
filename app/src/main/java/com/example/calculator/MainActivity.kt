package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var firstNumber = ""
    private var secondNumber = ""
    private var selectedOperator = ""
    private var result = 0.0

    fun InputAngka(view: View) {
        val number = (view as Button).text.toString()
        if (selectedOperator.isEmpty()) {
            firstNumber += number
            findViewById<TextView>(R.id.angka).text = firstNumber
        }  else {
            secondNumber += number
            findViewById<TextView>(R.id.angka).text = secondNumber
        }
    }


    fun InputOperator(view: View) {
        if (selectedOperator.isNotEmpty() && firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
            Hitung(view) // Hitung hasil sebelumnya
        }
        val operator = (view as Button).text.toString()
        selectedOperator = operator
        findViewById<TextView>(R.id.operasi).text = operator
    }


    fun Hitung(view: View) {
        if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && selectedOperator.isNotEmpty()) {
            val firstNum = firstNumber.toDouble()
            val secondNum = secondNumber.toDouble()

            result = when (selectedOperator) {
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                "x" -> firstNum * secondNum
                "÷" -> firstNum / secondNum
                else -> 0.0
            }

            findViewById<TextView>(R.id.angka).text = result.toString()
            firstNumber = result.toString()
            secondNumber = ""
            selectedOperator = ""

            if (view.id == R.id.btn_hasil) {
                findViewById<TextView>(R.id.operasi).text = ""
            } else {
                findViewById<TextView>(R.id.operasi).text = (view as Button).text
            }
        }
    }


    fun Clear(view: View) {
        firstNumber = ""
        secondNumber = ""
        selectedOperator = ""
        result = 0.0
        findViewById<TextView>(R.id.angka).text = ""
        findViewById<TextView>(R.id.operasi).text = ""
    }
}