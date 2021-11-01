package com.nprmanbrandons11.navegacinjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class splashactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
    }
}