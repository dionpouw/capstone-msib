package com.aldion.capstonemsib.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aldion.capstonemsib.data.entity.Statement
import java.util.concurrent.Executors

@Database(entities = [Statement::class], version = 1, exportSchema = false)
abstract class StatementDatabase : RoomDatabase() {

    abstract fun statementDao(): StatementDao

    companion object {
        @Volatile
        private var INSTANCE: StatementDatabase? = null

        fun getInstance(context: Context): StatementDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StatementDatabase::class.java,
                    "statement"
                ).addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        INSTANCE?.let {
                            Executors.newSingleThreadExecutor().execute {
                                populateDbAsyncTask(it.statementDao())
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }

        private fun populateDbAsyncTask(statementDao: StatementDao) {
            statementDao.insert(
                Statement(
                    1,
                    "Saya tidak merasa sedih",
                    "Saya merasa sedih",
                    "Saya sedih sepanjang waktu dan tidak dapat menghilangkannya",
                    "Saya begitu sedih sehingga merasa tidak tahan lagi"
                )
            )
            statementDao.insert(
                Statement(
                    2,
                    "Saya tidak merasa berkecil hati terhadap masa depan",
                    "Saya merasa berkecil hati terhadap masa depan",
                    "Saya merasa tidak ada sesuatu yang saya nantikan",
                    "Saya merasa bahwa tidak ada harapan di masa depan dan segala sesuatunya tidak dapat diperbaiki"
                )
            )
            statementDao.insert(
                Statement(
                    3,
                    "Saya tidak merasa gagal",
                    "Saya merasa lebih banyak mengalami kegagalan",
                    "Kalau meninjau Kembali kehidupan saya, yang dapat saya lihat hanyalah banyak kegagalan",
                    "Saya merasa sebagai seorang pribadi yang gagal total"
                )
            )
            statementDao.insert(
                Statement(
                    4,
                    "Saya mendapatkan kepuasan atas segala sesuatu seperti biasanya",
                    "Saya tidak dapat menikmati sesuatu seperti biasanya",
                    "Saya tidak lagi memperoleh kepuasan yang nyata dari segala sesuatu",
                    "Saya merasa tidak puas / bosan terhadap apa saja",
                )
            )
            statementDao.insert(
                Statement(
                    5,
                    "Saya tidak merasa bersalah",
                    "Saya cukup sering merasa bersalah",
                    "Saya sering merasa sangat bersalah",
                    "Saya merasa bersalah sepanjang waktu"
                )
            )
            statementDao.insert(
                Statement(
                    6,
                    "Saya tidak merasa bahwa saya sedang dihukum",
                    "Saya merasa bahwa saya mungkin dihukum",
                    "Saya mengharapkan agar saya dihukum",
                    "Saya merasa bahwa saya sedang dihukum"
                )
            )
            statementDao.insert(
                Statement(
                    7,
                    "Saya tidak kecewa terhadap diri sendiri",
                    "Saya kecewa terhadap diri sendiri",
                    "Saya merasa jijik terhadap diri sendiri",
                    "Saya membenci diri sendiri"
                )
            )
            statementDao.insert(
                Statement(
                    8,
                    "Saya tidak merasa lebih buruk dari orang lain",
                    "Saya selalu mencela diri sendiri karena kelemahan atau kekeliruan saya",
                    "Saya menyalahkan diri sendiri sepanjang waktu atas kesalahan sendiri sepanjang waktu",
                    "Saya menyalahkan diri sendiri atas semua hal buruk yang terjadi"
                )
            )
            statementDao.insert(
                Statement(
                    9,
                    "Saya tidak mempunyai pikiran untuk bunuh diri",
                    "Saya mempunyai pikiran untuk bunuh diri, tapi tidak akan melaksanakannya",
                    "Saya ingin bunuh diri",
                    "Saya akan bunuh diri kalau ada kesempatan",
                )
            )
            statementDao.insert(
                Statement(
                    10,
                    "Saya tidak menangis lebih dari biasanya",
                    "Sekarang saya lebih banyak menangis dari biasanya",
                    "Sekarang saya menangis sepanjang waktu",
                    "Saya biasanya dapat menangis, tetapi sekarang saya tidak dapat menangis meskipun ingin menangis"
                )
            )
            statementDao.insert(
                Statement(
                    11,
                    "Sekarang saya tidak lebih jengkel dari sebelum nya",
                    "Saya lebih mudah jengkel / marah dari biasanya",
                    "Saya sekarang merasa jengkel sepanjang waktu",
                    "Saya tidak jengkel oleh hal-hal yang biasanya menjengkelkan"
                )
            )
            statementDao.insert(
                Statement(
                    12,
                    "Saya masih senang bergaul dengan orang lain",
                    "Saya kurang berminat pada orang lain dibandingkan biasanya",
                    "Saya kehilangan Sebagian besar minat pada orang lain",
                    "Saya kehilangan seluruh minat pada orang lain"
                )
            )
            statementDao.insert(
                Statement(
                    13,
                    "Saya mengambil keputusan-keputusan sama baiknya dengan sebelumnya",
                    "Saya lebih banyak menunda keputusan dari biasanya",
                    "Saya mempunyai kesulitan yang lebih besar dalam mengambil keputusan dari sebelumnya",
                    "Saya sama sekali tidak dapat mengambil keputusan"
                )
            )
            statementDao.insert(
                Statement(
                    14,
                    "Saya tidak merasa lebih buruk dari sebelumnya",
                    "Saya cemas jangan-jangan sudah tua dan tidak menarik",
                    "Saya merasa ada perubahan dalam penampilan sehingga tidak menarik firefox",
                    "Saya yakin terlihat buruk"
                )
            )
            statementDao.insert(
                Statement(
                    15,
                    "Saya dapat bekerja dengan baik seperti sebelumnya",
                    "Saya membutuhkan usaha keras untuk mulai mengerjakan sesuatu",
                    "Saya harus memaksakan diri untuk mengerjakan sesuatu",
                    "Saya sama sekali tidak dapat mengerjakan apa-apa"
                )
            )
            statementDao.insert(
                Statement(
                    16,
                    "Saya dapat tidur nyenyak seperti biasanya",
                    "Saya tidak dapat tidur nyenyak seperti biasanya",
                    "Saya bangun pagi jam lebih awal dari biasanya dan sukar tidur Kembali",
                    "Saya bangun beberapa jam lebih awal dari pada biasanya dan tidak dapat tidur Kembali"
                )
            )
            statementDao.insert(
                Statement(
                    17,
                    "Saya tidak lebih Lelah dari biasanya",
                    "Saya lebih mudah Lelah dari biasanya",
                    "Saya hampir selalu merasa Lelah dalam mengerjakan sesuatu",
                    "Saya merasa terlalu Lelah untuk mengerjakan apa saja"
                )
            )
            statementDao.insert(
                Statement(
                    18,
                    "Nafsu makan saya masih seperti biasanya",
                    "Nafsu makan saya tidak sebesar biasanya",
                    "Sekarang nafsu makan saya jauh lebih berkurang",
                    "Saya tidak mempunyai nafsu makan sama sekali"
                )
            )
            statementDao.insert(
                Statement(
                    19,
                    "Saya tidak banyak kehilangan berat badan",
                    "Saya kehilangan berat badan 2,5 kg lebih",
                    "Saya kehilangan berat badan 5 kg lebih",
                    "Saya kehilangan BB 7,5 kg lebih"
                )
            )
            statementDao.insert(
                Statement(
                    20,
                    "Saya tidak mencemaskan Kesehatan fisik saya",
                    "Saya mencemaskan Kesehatan fisik saya; rasa nyeri seperti sakit perut atau sembelit",
                    "Saya sangat cemas akan masalah fisik saya dan sulit memikirkan hal-hal lain",
                    "Saya begitu cemas akan kesehatan fisik sehingga tidak dapat berpikir hal-hal lain"
                )
            )
            statementDao.insert(
                Statement(
                    21,
                    "Saya tidak merasa ada perubahan dalam minat terhadap seks (akhir-akhir ini)",
                    "Saya kurang berminat pada seks dibandingkan biasanya",
                    "Sekarang saya sangat kurang berminat pada seks",
                    "Saya sama sekali kehilangan minat terhadap seks"
                )
            )
        }
    }
}