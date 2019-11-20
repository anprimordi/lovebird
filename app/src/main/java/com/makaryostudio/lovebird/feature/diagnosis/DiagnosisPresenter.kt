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
            Gejala(0, "Nafsu Makan Menurun", 5f),
            Gejala(1,"Kotoran Cair",3f),
            Gejala(2, "Bulu Tidak Rapi", 2f),
            Gejala(3, "Kurang Bergairah/Lemas", 3f),
            Gejala(4, "Bobot Burung Menurun", 2f),
            Gejala(5, "Jarang Berkicau", 2f),
            Gejala(6, "Sering Menggigit Bulu", 2f),
            Gejala(7, "Kotoran Berwarna Keruh", 2f),
            Gejala(8, "Kotoran Berbau Busuk", 2f),
            Gejala(9, "Banyak Kutu", 4f),
            Gejala(10, "Sayang Menggantung", 5f),
            Gejala(11, "Mata Berair", 4f),
            Gejala(12, "Mata Bengkak", 3f),
            Gejala(13, "Kaki Bengkak", 3f),
            Gejala(14, "Kuku Memanjang", 2f),
            Gejala(15, "Lemah", 3f),
            Gejala(16, "Kelumpuhan Anggota Badan", 4f),
            Gejala(17, "Kotoran Seperti Kapur", 3f)

        )

        view.onLoadListGejalaSucceed(listGejala)
    }

    override fun start() {
        loadListGejala()
    }
}