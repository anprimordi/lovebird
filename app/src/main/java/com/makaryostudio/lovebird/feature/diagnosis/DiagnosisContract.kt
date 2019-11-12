package com.makaryostudio.lovebird.feature.diagnosis

import com.makaryostudio.lovebird.base.BasePresenter
import com.makaryostudio.lovebird.base.BaseView
import com.makaryostudio.lovebird.repository.model.Gejala

interface DiagnosisContract {
    interface Presenter: BasePresenter{
        fun loadListGejala()
    }

    interface View: BaseView<Presenter>{
        fun onLoadListGejalaSucceed(listGejala: List<Gejala>)
    }
}