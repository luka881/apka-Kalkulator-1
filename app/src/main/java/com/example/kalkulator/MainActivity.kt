package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextResult: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonEquals: Button
    private lateinit var buttonClear: Button

    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextResult = findViewById(R.id.editTextResult)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonEquals = findViewById(R.id.buttonEquals)
        buttonClear = findViewById(R.id.buttonClear)

        buttonAdd.setOnClickListener { handleOperation("+") }
        buttonEquals.setOnClickListener { handleEquals() }
        buttonClear.setOnClickListener { clear() }
    }

    private fun handleOperation(operator: String) {
        operand1 = editTextResult.text.toString().toDouble()
        operation = operator
        editTextResult.setText("")
    }

    private fun handleEquals() {
        operand2 = editTextResult.text.toString().toDouble()
        val result: Double = when (operation) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
        editTextResult.setText(result.toString())
    }

    private fun clear() {
        editTextResult.setText("")
        operand1 = 0.0
        operand2 = 0.0
        operation = ""
    }
}