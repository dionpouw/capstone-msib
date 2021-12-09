package com.aldion.capstonemsib.ui.testscreen.question

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding
import com.aldion.capstonemsib.utils.ViewModelFactory

class QuestionTestActivity : AppCompatActivity(), View.OnClickListener {
    private val binding get() = _binding
    private var _binding: ActivityQuestionTestBinding? = null
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Statement>? = null
    private var mSelectedOptionPosition: Int = 0
    private lateinit var viewModel: QuestionTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityQuestionTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[QuestionTestViewModel::class.java]

        viewModel.question.observe(this, {
            mQuestionList = it
        })

        setQuestion()

        binding?.btnOption1?.setOnClickListener(this)
        binding?.btnOption2?.setOnClickListener(this)
        binding?.btnOption3?.setOnClickListener(this)
        binding?.btnOption4?.setOnClickListener(this)
        binding?.btnNext?.setOnClickListener(this)
        binding?.btnPrevious?.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val question = mQuestionList!!.get(mCurrentPosition - 1)
        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size) {
            binding?.btnNext?.text = "Finish"
        } else {
            binding?.btnNext?.text = "Submit"
        }
        binding?.pbQuestion?.progress= mCurrentPosition
        binding?.tvProgress?.text = "$mCurrentPosition" + "/" + binding?.pbQuestion?.max
        binding?.btnOption1?.text = question.optA
        binding?.btnOption2?.text = question.optB
        binding?.btnOption3?.text = question.optC
        binding?.btnOption4?.text = question.optD

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}