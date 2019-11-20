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
            Gejala(1, "Nafsu Makan Menurun", 5),
            Gejala(2,"Kotoran Cair",3),
            Gejala(3, "Bulu Tidak Rapi", 2),
            Gejala(4, "Kurang Bergairah/Lemas", 3),
            Gejala(5, "Bobot Burung Menurun", 2),
            Gejala(6, "Jarang Berkicau", 2),
            Gejala(7, "Sering Menggigit Bulu", 2),
            Gejala(8, "Kotoran Berwarna Keruh", 2),
            Gejala(9, "Kotoran Berbau Busuk", 2),
            Gejala(10, "Banyak Kutu", 4),
            Gejala(11, "Sayang Menggantung", 5),
            Gejala(12, "Mata Berair", 4),
            Gejala(13, "Mata Bengkak", 3),
            Gejala(14, "Kaki Bengkak", 3),
            Gejala(15, "Kuku Memanjang", 2),
            Gejala(16, "Lemah", 3),
            Gejala(17, "Kelumpuhan Anggota Badan", 4),
            Gejala(18, "Kotoran Seperti Kapur", 3)

        )

        view.onLoadListGejalaSucceed(listGejala)
    }

    override fun start() {
        loadListGejala()
    }
}