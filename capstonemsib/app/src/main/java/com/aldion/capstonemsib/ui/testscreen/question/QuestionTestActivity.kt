package com.aldion.capstonemsib.ui.testscreen.question

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.aldion.capstonemsib.R
import com.aldion.capstonemsib.data.entity.Statement
import com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding
import com.aldion.capstonemsib.ui.testscreen.result.ResultTestActivity
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

        binding?.tvOption1?.setOnClickListener(this)
        binding?.tvOption2?.setOnClickListener(this)
        binding?.tvOption3?.setOnClickListener(this)
        binding?.tvOption4?.setOnClickListener(this)
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
        binding?.pbQuestion?.progress = mCurrentPosition
        binding?.tvProgress?.text = "$mCurrentPosition" + "/" + binding?.pbQuestion?.max
        binding?.tvOption1?.text = question.optA
        binding?.tvOption2?.text = question.optB
        binding?.tvOption3?.text = question.optC
        binding?.tvOption4?.text = question.optD

    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView?>()
        options.add(0, binding?.tvOption1)
        options.add(1, binding?.tvOption2)
        options.add(2, binding?.tvOption3)
        options.add(3, binding?.tvOption4)

        for (option in options) {
            option?.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.background = ContextCompat.getDrawable(this, R.drawable.shape_rectangle_primary)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOption1 -> {
                binding?.tvOption1?.let { selectedOptionView(it, selectedOptionNum = 1) }
            }
            R.id.tvOption2 -> {
                binding?.tvOption2?.let { selectedOptionView(it, selectedOptionNum = 2) }
            }
            R.id.tvOption3 -> {
                binding?.tvOption3?.let { selectedOptionView(it, selectedOptionNum = 3) }
            }
            R.id.tvOption4 -> {
                binding?.tvOption4?.let { selectedOptionView(it, selectedOptionNum = 4) }
            }
            R.id.btnNext -> {
                if (mSelectedOptionPosition == 0) {
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultTestActivity::class.java)
                            startActivity(intent)
                        }
                    }
                } else {
                    if (mCurrentPosition == mQuestionList!!.size) {
                        binding?.btnNext?.text = getString(R.string.finish)
                    } else {
                        binding?.btnNext?.text = getString(R.string.next_question)
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}