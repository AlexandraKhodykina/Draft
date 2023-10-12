package com.bignerdranch.android.draft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    private lateinit var answerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        var result = intent.getIntExtra("result", -1);
        answerText = findViewById(R.id.textView3)
        answerText.text = "Стоимость = $result руб.";
    }
}


