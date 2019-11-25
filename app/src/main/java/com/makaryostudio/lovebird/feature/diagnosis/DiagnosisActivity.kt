package com.makaryostudio.lovebird.feature.diagnosis

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.model.Gejala

class DiagnosisActivity : AppCompatActivity(), DiagnosisContract.View {

    override val presenter: DiagnosisContract.Presenter
        get() = DiagnosisPresenter(this)

    private lateinit var rvGejala: RecyclerView
    private lateinit var adapter: DiagnosisAdapter

    private lateinit var btnDiagnosis: FloatingActionButton

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

        btnDiagnosis = findViewById(R.id.button_diagnosis)

        btnDiagnosis.setOnClickListener {
            if (adapter.mCheckedGejala.isEmpty()) {
                Toast.makeText(this, R.string.diagnosis_empty_msg, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                adapter.cbr()
                finish()
            }
        }

        bindView()
    }

    private fun bindView() {
        rvGejala = findViewById(R.id.rv_gejala)
        rvGejala.layoutManager = LinearLayoutManager(this)
        adapter = DiagnosisAdapter(this)
        rvGejala.adapter = adapter
    }
}
