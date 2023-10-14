package com.bignerdranch.android.draft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.Button
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider



class MainActivity : AppCompatActivity() {
    private lateinit var okButton: Button
    private lateinit var numberInput: EditText
    private lateinit var RadioGroup: RadioGroup
    private lateinit var oneRadioButton: RadioButton
    private lateinit var twoRadioButton: RadioButton
    private lateinit var threeRadioButton: RadioButton
    private lateinit var forRadioButton: RadioButton
    private var cost: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RadioGroup = findViewById(R.id.radioGroup)
        okButton = findViewById(R.id.buttonOk)
        numberInput = findViewById(R.id.editTextText)
        oneRadioButton = findViewById(R.id.radioButton4)
        twoRadioButton = findViewById(R.id.radioButton5)
        threeRadioButton = findViewById(R.id.radioButton6)
        forRadioButton = findViewById(R.id.radioButton)

        oneRadioButton.setOnClickListener(variantListener)
        twoRadioButton.setOnClickListener(variantListener)
        threeRadioButton.setOnClickListener(variantListener)
        forRadioButton.setOnClickListener(variantListener)


        okButton.setOnClickListener {
            val result = updateResult()
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }

    private val variantListener = View.OnClickListener {
        when(RadioGroup.checkedRadioButtonId){
            R.id.radioButton4 ->updateCost(50)
            R.id.radioButton5 ->updateCost(57)
            R.id.radioButton6 ->updateCost(55)
            R.id.radioButton ->updateCost(60)
            else -> updateCost(0)
        }
    }

    private fun updateCost(c: Int)
    {
        cost=c
    }

    private fun updateResult(): Int
    {
        return (numberInput.text.toString().toInt() * cost)
    }
}


