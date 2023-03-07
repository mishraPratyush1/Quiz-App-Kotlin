package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start : Button = findViewById(R.id.startButton)
        val name : AppCompatEditText = findViewById(R.id.inputName)


        start.setOnClickListener {
            if(name.text.toString().isEmpty()){
                Toast.makeText(this,R.string.please_enter_your_name,Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())

                startActivity(intent)
                finish() // cannot come back to previous activity
            }
        }

    }
}