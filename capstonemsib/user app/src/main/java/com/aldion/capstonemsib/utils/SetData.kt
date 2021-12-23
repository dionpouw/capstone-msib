package com.aldion.capstonemsib.utils

import com.aldion.capstonemsib.data.entity.Statement

object SetData {

    fun getQuestion(): List<Statement> {
        val question = ArrayList<Statement>()

        question.add(
            Statement(
                1,
                "Saya tidak merasa sedih",
                "Saya merasa sedih",
                "Saya sedih sepanjang waktu dan tidak dapat menghilangkannya",
                "Saya begitu sedih sehingga merasa tidak tahan lagi"
            )
        )
        question.add(
            Statement(
                2,
                "Saya tidak merasa berkecil hati terhadap masa depan",
                "Saya merasa berkecil hati terhadap masa depan",
                "Saya merasa tidak ada sesuatu yang saya nantikan",
                "Saya merasa bahwa tidak ada harapan di masa depan dan segala sesuatunya tidak dapat diperbaiki"
            )
        )
        question.add(
            Statement(
                3,
                "Saya tidak merasa gagal",
                "Saya merasa lebih banyak mengalami kegagalan",
                "Kalau meninjau Kembali kehidupan saya, yang dapat saya lihat hanyalah banyak kegagalan",
                "Saya merasa sebagai seorang pribadi yang gagal total"
            )
        )
        question.add(
            Statement(
                4,
                "Saya mendapatkan kepuasan atas segala sesuatu seperti biasanya",
                "Saya tidak dapat menikmati sesuatu seperti biasanya",
                "Saya tidak lagi memperoleh kepuasan yang nyata dari segala sesuatu",
                "Saya merasa tidak puas / bosan terhadap apa saja",
            )
        )
        question.add(
            Statement(
                5,
                "Saya tidak merasa bersalah",
                "Saya cukup sering merasa bersalah",
                "Saya sering merasa sangat bersalah",
                "Saya merasa bersalah sepanjang waktu"
            )
        )
        question.add(
            Statement(
                6,
                "Saya tidak merasa bahwa saya sedang dihukum",
                "Saya merasa bahwa saya mungkin dihukum",
                "Saya mengharapkan agar saya dihukum",
                "Saya merasa bahwa saya sedang dihukum"
            )
        )
        question.add(
            Statement(
                7,
                "Saya tidak kecewa terhadap diri sendiri",
                "Saya kecewa terhadap diri sendiri",
                "Saya merasa jijik terhadap diri sendiri",
                "Saya membenci diri sendiri"
            )
        )
        question.add(
            Statement(
                8,
                "Saya tidak merasa lebih buruk dari orang lain",
                "Saya selalu mencela diri sendiri karena kelemahan atau kekeliruan saya",
                "Saya menyalahkan diri sendiri sepanjang waktu atas kesalahan sendiri sepanjang waktu",
                "Saya menyalahkan diri sendiri atas semua hal buruk yang terjadi"
            )
        )
        question.add(
            Statement(
                9,
                "Saya tidak mempunyai pikiran untuk bunuh diri",
                "Saya mempunyai pikiran untuk bunuh diri, tapi tidak akan melaksanakannya",
                "Saya ingin bunuh diri",
                "Saya akan bunuh diri kalau ada kesempatan",
            )
        )
        question.add(
            Statement(
                10,
                "Saya tidak menangis lebih dari biasanya",
                "Sekarang saya lebih banyak menangis dari biasanya",
                "Sekarang saya menangis sepanjang waktu",
                "Saya biasanya dapat menangis, tetapi sekarang saya tidak dapat menangis meskipun ingin menangis"
            )
        )
        question.add(
            Statement(
                11,
                "Sekarang saya tidak lebih jengkel dari sebelum nya",
                "Saya lebih mudah jengkel / marah dari biasanya",
                "Saya sekarang merasa jengkel sepanjang waktu",
                "Saya tidak jengkel oleh hal-hal yang biasanya menjengkelkan"
            )
        )
        question.add(
            Statement(
                12,
                "Saya masih senang bergaul dengan orang lain",
                "Saya kurang berminat pada orang lain dibandingkan biasanya",
                "Saya kehilangan Sebagian besar minat pada orang lain",
                "Saya kehilangan seluruh minat pada orang lain"
            )
        )
        question.add(
            Statement(
                13,
                "Saya mengambil keputusan-keputusan sama baiknya dengan sebelumnya",
                "Saya lebih banyak menunda keputusan dari biasanya",
                "Saya mempunyai kesulitan yang lebih besar dalam mengambil keputusan dari sebelumnya",
                "Saya sama sekali tidak dapat mengambil keputusan"
            )
        )
        question.add(
            Statement(
                14,
                "Saya tidak merasa lebih buruk dari sebelumnya",
                "Saya cemas jangan-jangan sudah tua dan tidak menarik",
                "Saya merasa ada perubahan dalam penampilan sehingga tidak menarik",
                "Saya yakin terlihat buruk"
            )
        )
        question.add(
            Statement(
                15,
                "Saya dapat bekerja dengan baik seperti sebelumnya",
                "Saya membutuhkan usaha keras untuk mulai mengerjakan sesuatu",
                "Saya harus memaksakan diri untuk mengerjakan sesuatu",
                "Saya sama sekali tidak dapat mengerjakan apa-apa"
            )
        )
        question.add(
            Statement(
                16,
                "Saya dapat tidur nyenyak seperti biasanya",
                "Saya tidak dapat tidur nyenyak seperti biasanya",
                "Saya bangun pagi jam lebih awal dari biasanya dan sukar tidur Kembali",
                "Saya bangun beberapa jam lebih awal dari pada biasanya dan tidak dapat tidur Kembali"
            )
        )
        question.add(
            Statement(
                17,
                "Saya tidak lebih Lelah dari biasanya",
                "Saya lebih mudah Lelah dari biasanya",
                "Saya hampir selalu merasa Lelah dalam mengerjakan sesuatu",
                "Saya merasa terlalu Lelah untuk mengerjakan apa saja"
            )
        )
        question.add(
            Statement(
                18,
                "Nafsu makan saya masih seperti biasanya",
                "Nafsu makan saya tidak sebesar biasanya",
                "Sekarang nafsu makan saya jauh lebih berkurang",
                "Saya tidak mempunyai nafsu makan sama sekali"
            )
        )
        question.add(
            Statement(
                19,
                "Saya tidak banyak kehilangan berat badan",
                "Saya kehilangan berat badan 2,5 kg lebih",
                "Saya kehilangan berat badan 5 kg lebih",
                "Saya kehilangan BB 7,5 kg lebih"
            )
        )
        question.add(
            Statement(
                20,
                "Saya tidak mencemaskan Kesehatan fisik saya",
                "Saya mencemaskan Kesehatan fisik saya; rasa nyeri seperti sakit perut atau sembelit",
                "Saya sangat cemas akan masalah fisik saya dan sulit memikirkan hal-hal lain",
                "Saya begitu cemas akan kesehatan fisik sehingga tidak dapat berpikir hal-hal lain"
            )
        )
        question.add(
            Statement(
                21,
                "Saya tidak merasa ada perubahan dalam minat terhadap seks (akhir-akhir ini)",
                "Saya kurang berminat pada seks dibandingkan biasanya",
                "Sekarang saya sangat kurang berminat pada seks",
                "Saya sama sekali kehilangan minat terhadap seks"
            )
        )

        return question
    }
}