package com.makaryostudio.lovebird.feature.hasil

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.model.Gejala

class HasilActivity : AppCompatActivity() {
    private lateinit var rvGejalaDialami: RecyclerView
    private lateinit var adapter: HasilAdapter
    private lateinit var textHasilDiagnosis: TextView
    private lateinit var textSolusi: TextView
    private lateinit var textPencegahan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        bindView()

        textHasilDiagnosis = findViewById(R.id.text_hasil_diagnosis)
        textSolusi = findViewById(R.id.text_solusi)
        textPencegahan = findViewById(R.id.text_pencegahan)

        val checked = intent.getParcelableArrayListExtra<Gejala>("checked")
        val penyakitBurung = intent.getStringExtra("penyakit")
        val solusi = intent.getStringExtra("solusi")
        val pencegahan = intent.getStringExtra("pencegahan")

        val mListData: List<Gejala> = checked

        adapter.loadListData(mListData)

        textHasilDiagnosis.text = penyakitBurung!!.toString()
        textSolusi.text = solusi
        textPencegahan.text = pencegahan
    }

    private fun bindView() {
        rvGejalaDialami = findViewById(R.id.rv_gejala_dialami)
        rvGejalaDialami.layoutManager = LinearLayoutManager(this)
        adapter = HasilAdapter()
        rvGejalaDialami.adapter = adapter
    }
}
