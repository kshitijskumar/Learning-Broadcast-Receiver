package com.example.learningbroadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BroadcastReceiverClass : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action ?: return
        Log.d("BroadcastReceiver", "${intent.getBooleanArrayExtra("state")}")

        if (action == Intent.ACTION_USER_PRESENT){
            Toast.makeText(context, "Device Unlocked", Toast.LENGTH_SHORT).show()
        }

    }
}