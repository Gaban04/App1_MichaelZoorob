package com.example.dropdownmenu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //window.setflags is to hide the taskbar and allow the splash and/or loading screen to load as full screen.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        //Handler().postDelayed({}) & postDelayed(Runnable, time) is a method used for delaying time message.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 6000) //6000 is the amount of time delayed in milliseconds.
    }
}