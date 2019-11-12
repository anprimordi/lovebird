package com.makaryostudio.lovebird.feature.diagnosis

class DiagnosisPresenter internal constructor(private val view: DiagnosisContract.View) : DiagnosisContract.Presenter{
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