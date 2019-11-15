package com.makaryostudio.lovebird.feature.diagnosis

import com.makaryostudio.lovebird.repository.model.Gejala

class DiagnosisPresenter internal constructor(private val view: DiagnosisContract.View) :
    DiagnosisContract.Presenter {
    override fun getSelectedItems(isSelected: Boolean): ArrayList<Gejala> {
        TODO("mengambil list yang dipilih")
//        val list: ArrayList<Gejala>
//        for (i in 0..18 ) {
//
//
//        }
//        return list
    }

    override fun loadListGejala() {

        TODO("what kind of database are we going to use?")
//        val listGejala
//
//        view.onLoadListGejalaSucceed(listGejala)
    }

    override fun start() {
        loadListGejala()
    }
}