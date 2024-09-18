package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstNum = findViewById<EditText>(R.id.firstNumber)

        val secondNum = findViewById<EditText>(R.id.secondNumber)

        val intent = Intent(this,displayActivity::class.java)

        //For add button
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val firstNum = firstNum.text.toString()
            val secondNum = secondNum.text.toString()
            if(firstNum.toIntOrNull()==null || secondNum.toIntOrNull()==null){
                intent.putExtra("DISPLAY_MESSAGE","Enter two integers only")
                startActivity(intent)
            } else {
                val sum = firstNum.toInt() + secondNum.toInt()
                intent.putExtra("DISPLAY_MESSAGE","Result: "+sum.toString())
                startActivity(intent)
            }

        }

        //For subtract button
        val subButton = findViewById<Button>(R.id.subButton)
        subButton.setOnClickListener {
            val firstNum = firstNum.text.toString()
            val secondNum = secondNum.text.toString()
            if(firstNum.toIntOrNull()==null || secondNum.toIntOrNull()==null){
                intent.putExtra("DISPLAY_MESSAGE","Enter two integers only")
                startActivity(intent)
            } else {
                val sum = firstNum.toInt() - secondNum.toInt()
                intent.putExtra("DISPLAY_MESSAGE","Result: "+sum.toString())
                startActivity(intent)
            }

        }

        //For mult button
        val multButton = findViewById<Button>(R.id.multButton)
        multButton.setOnClickListener {
            val firstNum = firstNum.text.toString()
            val secondNum = secondNum.text.toString()
            if(firstNum.toIntOrNull()==null || secondNum.toIntOrNull()==null){
                intent.putExtra("DISPLAY_MESSAGE","Enter two integers only")
                startActivity(intent)
            } else {
                val sum = firstNum.toInt()*secondNum.toInt()
                intent.putExtra("DISPLAY_MESSAGE","Result: "+sum.toString())
                startActivity(intent)
            }

        }

        //For div button
        val divButton = findViewById<Button>(R.id.divButton)
        divButton.setOnClickListener {
            val firstNum = firstNum.text.toString()
            val secondNum = secondNum.text.toString()
            if(firstNum.toIntOrNull()==null || secondNum.toIntOrNull()==null) {
                intent.putExtra("DISPLAY_MESSAGE", "Enter two integers only")
                startActivity(intent)
            } else if(secondNum.toIntOrNull()==0) {
                intent.putExtra("DISPLAY_MESSAGE", "Divide by zero error")
                startActivity(intent)
            } else {
                val sum = firstNum.toInt()/secondNum.toInt()
                intent.putExtra("DISPLAY_MESSAGE","Result: "+sum.toString())
                startActivity(intent)
            }

        }
    }
}