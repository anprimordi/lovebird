package com.makaryostudio.lovebird.feature.diagnosis

import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.repository.model.Gejala

class DiagnosisPresenter internal constructor(private val view: DiagnosisContract.View) :
    DiagnosisContract.Presenter {
//    override fun getSelectedItems(isSelected: Boolean): ArrayList<Gejala> {
//        TODO("mengambil list yang dipilih")
//        var list: ArrayList<Gejala> = ArrayList()
//
//        val gejala: Gejala = Gejala()
//
//        gejala.checked
//    }

    override fun loadListGejala() {
        val listGejala = arrayListOf(
            Gejala(R.array.array_kode_gejala, R.array.array_nama_gejala, R.array.array_bobot_gejala)
        )

        view.onLoadListGejalaSucceed(listGejala)
    }

    override fun start() {
        loadListGejala()
    }
}