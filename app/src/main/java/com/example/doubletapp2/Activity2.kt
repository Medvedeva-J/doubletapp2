package com.example.doubletapp2

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import kotlin.math.pow
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    val TAG: String = "ActivityLifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        Log.d(TAG, "Activity2: onCreate()")
        var squareTV: TextView = findViewById(R.id.square_tv)
        squareTV.text = this.intent.extras?.getFloat("STATE_TEXTVIEW")?.pow(2)?.toInt().toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity2: onStart()")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity2: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity2: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity2: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity2: onDestroy()")
    }

    fun goToActivity1(view: View) {
        finish()
    }
}