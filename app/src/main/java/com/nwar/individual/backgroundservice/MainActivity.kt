package com.nwar.individual.backgroundservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val switch = findViewById<Switch>(R.id.sc_switch)
        val intent = Intent(applicationContext, CustomService::class.java)
        switch.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if(isChecked) {
                buttonView.text = "서비스 종료하기"
                startService(intent)
            } else {
                buttonView.text = "서비스 시작하기"
                stopService(intent)
            }
        }
    }
}
