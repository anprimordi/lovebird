package com.makaryostudio.lovebird.feature.diagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.feature.hasil.HasilActivity
import com.makaryostudio.lovebird.repository.model.Gejala

class DiagnosisActivity : AppCompatActivity(), DiagnosisContract.View {

    override val presenter: DiagnosisContract.Presenter
        get() = DiagnosisPresenter(this)

    private lateinit var rvGejala: RecyclerView
    private lateinit var adapter: DiagnosisAdapter
    private lateinit var textNamaBurung: EditText
    private lateinit var btnDiagnosis: Button


    override fun onLoadListGejalaSucceed(listGejala: List<Gejala>) {
        rvGejala.setHasFixedSize(true)
        adapter.loadListData(listGejala)
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnosis)

        btnDiagnosis.setOnClickListener {
            intent = Intent()
            intent.putExtra("namaburung", textNamaBurung.toString())
            intent = Intent(this, HasilActivity::class.java)
            startActivity(intent)
        }

        bindView()
    }

    private fun bindView() {
        textNamaBurung = findViewById(R.id.edit_nama_burung)
        btnDiagnosis = findViewById(R.id.button_diagnosis)

        rvGejala = findViewById(R.id.rv_gejala)
        rvGejala.layoutManager = LinearLayoutManager(this)
        adapter = DiagnosisAdapter(this)
        rvGejala.adapter = adapter
    }
}
