package com.cs.calculater

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    private lateinit var calculatorTextView:TextView
    private lateinit var displayTextView:TextView
    private lateinit var displayTextView1:TextView
    private var input: String = ""
    private var operator: String = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        calculatorTextView = findViewById(R.id.calculatorTextView)
        displayTextView = findViewById(R.id.displayTextView)
        displayTextView1 = findViewById(R.id.displayTextView1)

        val equalsButton: Button = findViewById(R.id.equalsButton)
        equalsButton.setOnClickListener {
            calculateResult()
        }
        val buttonClear: Button = findViewById(R.id.buttonClear)
        buttonClear.setOnClickListener {
            clearCalculator()
        }

        // ---------------Operator buttons-----------------------//

        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        buttonPlus.setOnClickListener {
            storeOperator("+")
        }

        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        buttonMinus.setOnClickListener {
            storeOperator("-")
        }
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        buttonMultiply.setOnClickListener {
            storeOperator("*")
        }
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        buttonDivide.setOnClickListener {
            storeOperator("/")
        }

        //-------------Number buttons----------------------//

        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener {
            appendInput("0")
        }

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            appendInput("1")
        }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            appendInput("2")
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            appendInput("3")
        }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            appendInput("4")
        }
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            appendInput("5")
        }
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener {
            appendInput("6")
        }
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener {
            appendInput("7")
        }
        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener {
            appendInput("8")
        }
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener {
            appendInput("9")
        }
        val buttonDot: Button = findViewById(R.id.buttonDot)
        buttonDot.setOnClickListener {
            appendInput(".")
        }

    }

    private fun appendInput(value: String) {
        input += value
        displayTextView.text = input
    }

    @SuppressLint("SetTextI18n")
    private fun storeOperator(operator: String) {
        if (input.isNotEmpty()) {
            operand1 = input.toDouble()
            this.operator = operator
            input = ""

        }
    }
    private fun clearCalculator() {
        input = ""
        operator = ""
        operand1 = 0.0
        operand2 = 0.0
        displayTextView.text = ""
        displayTextView1.text = ""

    }


    @SuppressLint("SetTextI18n")
    private fun calculateResult() {

        try {
            operand2 = input.toDouble()

            var result = 0.0
            when (operator) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                "/" -> {
                    if (operand2 == 0.0) {
                        displayTextView.text = "Error: Division by zero"
                        return
                    }
                    result = operand1 / operand2
                }
            }


            if(operand2 == 0.0){
                displayTextView1.text = operand1.toString() + operator
            }
            else{
                displayTextView1.text = operand1.toString() + operator + operand2.toString()
            }
            displayTextView.text = result.toString()
            input = result.toString()
            operator = ""
            operand1 = result
        } catch (e: NumberFormatException) {
            displayTextView.text = "Error: Invalid input"
        }
    }
}

