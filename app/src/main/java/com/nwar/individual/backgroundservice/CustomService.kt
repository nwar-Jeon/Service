package com.nwar.individual.backgroundservice

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class CustomService : Service() {
    val a = CustomThread()
    var isStop = false
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        a.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isStop = true
    }

    inner class CustomThread : Thread() {
        override fun run() {
            while (!isStop) {
                Log.e("서비스 실행중", "...")
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {

                }
            }
        }
    }

}