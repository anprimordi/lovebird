package com.makaryostudio.lovebird.feature.hasil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.repository.model.Gejala

class HasilActivity : AppCompatActivity() {

    private lateinit var textNamaBurung: TextView
    private lateinit var adapter: RecyclerView
    private lateinit var textHasilDiagnosis: TextView
    private lateinit var textSolusi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        val gejala = intent.getParcelableExtra<Gejala>("gejala")
        val checked = intent.getBooleanArrayExtra("checked")
        val namaBurung = intent.getStringExtra("namaBurung")

        textNamaBurung.text = namaBurung

        bindView()
    }

    private fun bindView() {
        textNamaBurung = findViewById(R.id.text_nama_burung)
        adapter = findViewById(R.id.rv_gejala_dialami)
        textHasilDiagnosis = findViewById(R.id.text_hasil_diagnosis)
        textSolusi = findViewById(R.id.text_solusi)
    }
}
