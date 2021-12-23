package com.aldion.capstonemsib.ui.testscreen.question

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding
import com.aldion.capstonemsib.ui.testscreen.result.ResultTestActivity
import com.aldion.capstonemsib.utils.SetData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class QuestionTestActivity : AppCompatActivity() {
    private val binding get() = _binding
    private var _binding: ActivityQuestionTestBinding? = null
    private var currentQuestion = 0
    private var selectedOption = 0
    private lateinit var resultTest: ArrayList<Int>
    private lateinit var mDatabase: DatabaseReference
    private var datalist = ArrayList<Statement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityQuestionTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //mDatabase = FirebaseDatabase.getInstance().getReference("Question")
        datalist = SetData.getQuestion() as ArrayList<Statement>
        //getData()
        //print(datalist)
        setQuestion(currentQuestion)

        binding?.tvOption1?.setOnClickListener {
            selectedOptionStyle(binding?.tvOption1!!, 0)
        }
        binding?.tvOption2?.setOnClickListener {
            selectedOptionStyle(binding?.tvOption2!!, 1)
        }
        binding?.tvOption3?.setOnClickListener {
            selectedOptionStyle(binding?.tvOption3!!, 2)
        }
        binding?.tvOption4?.setOnClickListener {
            selectedOptionStyle(binding?.tvOption3!!, 3)
        }
    }

    private fun setQuestion(position: Int) {
        binding?.apply {
            tvProgress.text = getString(R.string.number_of_questions, position + 1)
            pbQuestion.progress = position + 1
            pbQuestion.max = datalist.size
            tvOption1.text = datalist[position].opt1
            tvOption2.text = datalist[position].opt2
            tvOption3.text = datalist[position].opt3
            tvOption4.text = datalist[position].opt4

            if (position != datalist.size - 1) {
                btnNext.setOnClickListener {
                    currentQuestion += 1
                    resultTest.add(selectedOption)
                    setQuestion(currentQuestion)

                }
                btnPrevious.setOnClickListener {
                    currentQuestion -= 1
                    setQuestion(currentQuestion)
                }
            } else {
                btnNext.text = getString(R.string.test_finished)
                btnNext.setOnClickListener {
                    val intent = Intent(this@QuestionTestActivity, ResultTestActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun selectedOptionStyle(view: TextView, opt: Int) {
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.shape_rectangle_primary)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#FFFFFF"))
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                datalist.clear()
                for (getDataSnapshot in snapshot.children) {
                    val question = getDataSnapshot.getValue(Statement::class.java)
                    datalist.addAll(listOf(question!!))
                    println(datalist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
