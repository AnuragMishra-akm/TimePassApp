package com.example.timepass

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var editText: TextInputEditText
    private lateinit var chkbtn: Button
    private lateinit var infotext: TextView
    private lateinit var attemptstext: TextView
    private lateinit var besttext: TextView
    var count = 100
    var currentCount = 0
//    var selectedNum = nextInt(1,100)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText = findViewById(R.id.guessednumber)
//        val selectednum = nextInt(1,100)
        chkbtn = findViewById(R.id.buttoncheck)
        infotext = findViewById(R.id.textViewbottom)
        attemptstext = findViewById(R.id.textViewAttempts)
        besttext = findViewById(R.id.besttextview)
//        var guessedtext = editText.text.toString()
        var selectedNum = nextInt(1, 100)
        Log.i(TAG, "Selected Num is $selectedNum")


        infotext.visibility = View.INVISIBLE
        attemptstext.visibility = View.INVISIBLE
        chkbtn.text = "Check"
        chkbtn.setOnClickListener {
            val guessednum: Int = editText.text.toString().toInt()
            currentCount++
            infotext.visibility = View.VISIBLE
            attemptstext.visibility = View.VISIBLE
            if (guessednum > selectedNum) {
                infotext.text = "Number Is Smaller Than $guessednum"
            } else if (guessednum < selectedNum) {
                infotext.text = "Number Is Greater Than $guessednum"
            } else {
                infotext.text = "Congrats!!, You Got It Right"
                chkbtn.text = "Replay"
                if (currentCount < count) {
                    count = currentCount
                }
                besttext.text = "Best : $count"
                chkbtn.setOnClickListener {
//            reset()
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            attemptstext.text = "No Of Attempts Is : $currentCount "


        }

    }


//    fun reset( selectedNum:Int){
////        selectedNum= nextInt(1,100)
//        infotext.visibility=View.INVISIBLE
//        attemptstext.visibility=View.INVISIBLE
//        currentCount=0
//        chkbtn.text="Check"
//    }
//        if (currentCount<count){
//            count=currentCount
//        }
//        besttext.text="Best : $count"
//
//    }
//    private fun test(selectednum:Int,guessednum:Int){
////        var guessedtext = editText.text.toString()
//        try {currentCount++
////            var guessednum = Integer.parseInt(guessedtext)
//            if (guessednum>selectednum){
//                infotext.text="Number Is Greater Than $guessednum"
//                attemptstext.text= "No Of Attempts Is : $currentCount "
//            }else if(guessednum<selectednum){
//                infotext.text="Number Is Smaller Than $guessednum"
//                attemptstext.text= "No Of Attempts Is : $currentCount "
//            }
//            else{
//                infotext.text="Correct!! Number Is $selectednum "
//                attemptstext.text= "No Of Attempts Is : $currentCount "
//            }

//        } catch(e: NumberFormatException){
//            Toast.makeText(this,"Please Enter Only Integer Values",Toast.LENGTH_SHORT).show()
//        }
//    }
}