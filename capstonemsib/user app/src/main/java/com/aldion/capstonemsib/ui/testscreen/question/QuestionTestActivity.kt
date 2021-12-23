package com.aldion.capstonemsib.ui.testscreen.question

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding
import com.google.firebase.database.*

class QuestionTestActivity : AppCompatActivity() {
    private val binding get() = _binding
    private var _binding: ActivityQuestionTestBinding? = null
    private lateinit var viewModel: QuestionTestViewModel
    private lateinit var mDatabase: DatabaseReference
    private var datalist = ArrayList<Statement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityQuestionTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("Question")
        getData()

        println(datalist)


    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                datalist.clear()
                for (getDataSnapshot in snapshot.children) {
                    val question = getDataSnapshot.getValue(Statement::class.java)
                    datalist.add(question!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }


    companion object {
        private const val TAG = "TAG"
    }
}
