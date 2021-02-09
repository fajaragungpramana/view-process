package com.github.fajaragungpramana.android

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.fajaragungpramana.viewprocess.ViewProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewProcess = findViewById<ViewProcess>(R.id.view_process)
        val btnStart = findViewById<Button>(R.id.btn_start)
        val btnStop = findViewById<Button>(R.id.btn_stop)

        btnStart.setOnClickListener {
            viewProcess.start
        }

        btnStop.setOnClickListener {
            viewProcess.stop
        }

    }

}