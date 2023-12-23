package com.example.android_bootcamp_day_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input : TextView = findViewById(R.id.inputTv)
        val output: TextView = findViewById(R.id.outputTv)
        val button_clear: AppCompatButton = findViewById(R.id.button_clear)
        val button_bracket_left: AppCompatButton = findViewById(R.id.button_bracket_left)
        val button_bracket_right: AppCompatButton = findViewById(R.id.button_bracket_right)
        val button_0: AppCompatButton = findViewById(R.id.button_0)
        val button_1: AppCompatButton = findViewById(R.id.button_1)
        val button_2: AppCompatButton = findViewById(R.id.button_2)
        val button_3: AppCompatButton = findViewById(R.id.button_3)
        val button_4: AppCompatButton = findViewById(R.id.button_4)
        val button_5: AppCompatButton = findViewById(R.id.button_5)
        val button_6: AppCompatButton = findViewById(R.id.button_6)
        val button_7: AppCompatButton = findViewById(R.id.button_7)
        val button_8: AppCompatButton = findViewById(R.id.button_8)
        val button_9: AppCompatButton = findViewById(R.id.button_9)
        val button_dot: AppCompatButton = findViewById(R.id.button_dot)
        val button_equals: AppCompatButton = findViewById(R.id.button_equals)
        val button_addition: AppCompatButton = findViewById(R.id.button_addition)
        val button_subtraction: AppCompatButton = findViewById(R.id.button_subtraction)
        val button_multiply: AppCompatButton = findViewById(R.id.button_multiply)
        val button_division: AppCompatButton = findViewById(R.id.button_division)


        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }

        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_division.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        button_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {

        val input: TextView = findViewById(R.id.inputTv)
        val output: TextView = findViewById(R.id.outputTv)

        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        val input: TextView = findViewById(R.id.inputTv)
        val output: TextView = findViewById(R.id.outputTv)

        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {

        val input: TextView = findViewById(R.id.inputTv)
        val output: TextView = findViewById(R.id.outputTv)

        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

}

