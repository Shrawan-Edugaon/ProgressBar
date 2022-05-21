package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prgBarHorizontal = findViewById<ProgressBar>(R.id.prgBar) as ProgressBar
        val startBtn = findViewById<Button>(R.id.start) as Button

        startBtn.setOnClickListener {
            var barStatus = 0
            Thread(Runnable {
                while (barStatus < 100) {
                    barStatus += 1
                    try {
                        Thread.sleep(20)
                        prgBarHorizontal.setProgress(barStatus)
                    } catch (exp: InterruptedException) {
                        exp.printStackTrace()
                    }
                }
            }).start()
        }
    }
}