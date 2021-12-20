//package com.aldion.capstonemsib.ui.testscreen.question
//
//import android.os.Bundle
//import android.view.View
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.ViewModelProvider
//import com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding
//import com.aldion.capstonemsib.utils.ViewModelFactory
//
//class QuestionTestActivity : AppCompatActivity(){
//    private val binding get() = _binding
//    private var _binding: ActivityQuestionTestBinding? = null
//    private lateinit var viewModel: QuestionTestViewModel
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        _binding = ActivityQuestionTestBinding.inflate(layoutInflater)
//        setContentView(binding?.root)
//
//        val factory = ViewModelFactory.getInstance(this)
//        viewModel = ViewModelProvider(this, factory)[QuestionTestViewModel::class.java]
//    }
//}