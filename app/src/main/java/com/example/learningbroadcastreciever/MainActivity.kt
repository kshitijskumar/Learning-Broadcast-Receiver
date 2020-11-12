package com.example.learningbroadcastreciever

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BroadcastReceiverClass.OnReceive {

    private val receiver by lazy { BroadcastReceiverClass(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IntentFilter(Intent.ACTION_USER_PRESENT).also {
            registerReceiver(receiver, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    @SuppressLint("SetTextI18n")
    override fun broadcastReceive() {
        tvHello.text = "Hello"
    }
}