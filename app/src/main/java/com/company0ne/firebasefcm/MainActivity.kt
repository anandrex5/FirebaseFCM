package com.company0ne.firebasefcm


import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            // Get new FCM registration token
            val token = task.result
            Log.e("myToken", "" + token)

            // Log and toast
//            val msg = getString(R.string.msg_token_fmt, token)
//            Log.d(TAG, msg)
//            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()

        })
    }
}