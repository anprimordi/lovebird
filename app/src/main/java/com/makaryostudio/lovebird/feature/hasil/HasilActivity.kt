package com.makaryostudio.lovebird.feature.hasil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.repository.model.Gejala
import com.makaryostudio.lovebird.repository.model.Penyakit


class HasilActivity : AppCompatActivity() {

    private lateinit var textNamaBurung: TextView

    private lateinit var adapter: RecyclerView
    private lateinit var textHasilDiagnosis: TextView
    private lateinit var textSolusi: TextView
    private lateinit var textPencegahan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)
        println("a")
        //textNamaBurung = findViewById(R.id.text_nama_burung)
        textHasilDiagnosis = findViewById(R.id.text_hasil_diagnosis)
        textSolusi = findViewById(R.id.text_deskripsi_solusi)
        textPencegahan=findViewById(R.id.text_pencegahan)

        val gejala = intent.getParcelableExtra<Gejala>("gejala")
        val checked = intent.getBooleanArrayExtra("checked")
        //val namaBurung = intent.getStringExtra("namaBurung")
        val penyakitBurung = intent.getStringExtra("penyakit")
        val solusi = intent.getStringExtra("solusi")
        val pencegahan = intent.getStringExtra("pencegahan")
        val cbr = intent.getStringExtra("persentaseCBR")
        // textNamaBurung = findViewById(R.id.namaBurung)

        //textNamaBurung.text = "Penyakit Burung: $penyakitBurung"
        textHasilDiagnosis.text = penyakitBurung
        textSolusi.text=solusi
        textPencegahan.text=pencegahan



        //textSolusi.text = cbr

        bindView()
    }

    private fun bindView() {

        adapter = findViewById(R.id.rv_gejala_dialami)


    }
}
