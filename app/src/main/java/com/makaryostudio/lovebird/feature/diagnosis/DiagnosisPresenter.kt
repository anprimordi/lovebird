package com.makaryostudio.lovebird.feature.diagnosis

import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.model.Gejala

class DiagnosisPresenter internal constructor(private val view: DiagnosisContract.View) :
    DiagnosisContract.Presenter {

    override fun loadListGejala() {
        val listGejala = arrayListOf(
            Gejala(
                R.drawable.ic_gejala_nafsu_makan_turun,
                0,
                "Nafsu Makan Menurun",
                "Burung cenderung tidak memakan makanan yang diberikan",
                5f
            ),
            Gejala(
                R.drawable.ic_gejala_kotoran_cair,
                1,
                "Kotoran Cair",
                "Kotoran burung lebih encer dari sebelumnya",
                3f
            ),
            Gejala(
                R.drawable.ic_gejala_bulu_tidak_rapi,
                2,
                "Bulu Tidak Rapi",
                "Bulu tidak rapi karena dipatuk oleh burung sendiri",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_kurang_bergairah,
                3,
                "Kurang Bergairah/Lemas",
                "Kurang aktif bergerak",
                3f
            ),
            Gejala(
                R.drawable.ic_gejala_bobot_turun,
                4,
                "Bobot Burung Menurun",
                "Berat badan burung menurun dibanding sebelumnya",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_jarang_berkicau,
                5,
                "Jarang Berkicau",
                "Burung tidak sering mengeluarkan suara atau berkicau",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_sering_menggigit_bulu,
                6,
                "Sering Menggigit Bulu",
                "Burung sering menggigit bulunya sendiri",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_kotoran_keruh,
                7,
                "Kotoran Berwarna Keruh",
                "Kotoran lebih berwarna gelap dari sebelumnya",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_kotoran_busuk,
                8,
                "Kotoran Berbau Busuk",
                "Bau kotoran burung tidak sedap berbeda dengan biasanya",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_banyak_kutu,
                9,
                "Banyak Kutu",
                "Terdapat banyak kutu pada bulu burung",
                4f
            ),
            Gejala(
                R.drawable.ic_gejala_sayap_menggantung,
                10,
                "Sayap Menggantung",
                "Sayap burung digantungkan kebawah",
                5f
            ),
            Gejala(
                R.drawable.ic_gejala_mata_berair,
                11,
                "Mata Berair",
                "Mata burung mengeluarkan cairan bening secara konstan",
                4f
            ),
            Gejala(
                R.drawable.ic_gejala_mata_bengkak,
                12,
                "Mata Bengkak",
                "Mata burung cenderung lebih besar dan membengkak",
                3f
            ),
            Gejala(
                R.drawable.ic_gejala_kaki_bengkak,
                13,
                "Kaki Bengkak",
                "Bengkak pada kaki burung",
                3f
            ),
            Gejala(
                R.drawable.ic_gejala_kuku_memanjang,
                14,
                "Kuku Memanjang",
                "Kuku lebih cepat memanjang",
                2f
            ),
            Gejala(
                R.drawable.ic_gejala_lemah,
                15,
                "Lemah",
                "Burung lemah kurang bersemangat",
                3f
            ),
            Gejala(
                R.drawable.ic_gejala_kelumpuhan,
                16,
                "Kelumpuhan Anggota Badan",
                "Anggota badan burung tidak dapat digerakkan",
                4f
            ),
            Gejala(
                R.drawable.ic_gejala_kotoran_putih,
                17,
                "Kotoran Berwarna Putih",
                "Warna kotoran burung putih seperti kapur",
                3f
            )
        )

        view.onLoadListGejalaSucceed(listGejala)
    }

    override fun start() {
        loadListGejala()
    }
}