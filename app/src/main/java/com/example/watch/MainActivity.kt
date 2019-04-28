package com.example.watch

import android.icu.text.SimpleDateFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)

        val runnable = object : Runnable {
            override fun run() {
                textView.text = getNow()
                handler.postDelayed(this, 1000)
            }
        }

        // 開始ボタン
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {
            handler.post(runnable)
        }

        // 停止ボタン
        val stopButton = findViewById<Button>(R.id.stop_button)
        stopButton.setOnClickListener {
            handler.removeCallbacks(runnable)
        }

    }

    /*
     * 現在の時刻を取得する
     */
    private fun getNow(): String {
        val date = Date()
        val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return format.format(date)
    }
}
