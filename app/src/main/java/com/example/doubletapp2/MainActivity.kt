package com.example.doubletapp2

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var currentNumber: Int = 0
    val TAG: String = "ActivityLifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity: onCreate()")
        var numberTV: TextView = findViewById(R.id.number_tv)
        if (savedInstanceState != null) {
            currentNumber = savedInstanceState.getFloat("STATE_TEXTVIEW").toInt()
        }
        numberTV.text = currentNumber.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity: onStart()")
        Log.d(TAG, "currentNumber = $currentNumber")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity: onDestroy()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        currentNumber += 1
        Log.d(TAG, "Configuration Changed: currentNumber = $currentNumber")
        var numberTV: TextView = findViewById(R.id.number_tv)
        numberTV.text = currentNumber.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putFloat("STATE_TEXTVIEW", currentNumber.toFloat())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        currentNumber = savedInstanceState.getFloat("STATE_TEXTVIEW").toInt()
        var numberTV: TextView = findViewById(R.id.number_tv)
        numberTV.text = currentNumber.toString()
    }

    fun goToActivity2(view: View) {
        val sendIntent = Intent(this, Activity2::class.java
        ).apply { putExtra("STATE_TEXTVIEW", currentNumber.toFloat()) }
        startActivity(sendIntent)
    }
}