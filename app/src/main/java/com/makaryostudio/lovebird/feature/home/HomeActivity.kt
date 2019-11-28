package com.makaryostudio.lovebird.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.feature.diagnosis.DiagnosisActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var btnMulai: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnMulai = findViewById(R.id.button_home_mulai)

        btnMulai.setOnClickListener {
            startActivity(Intent(this, DiagnosisActivity::class.java))
        }
    }
}
