package com.example.quiz_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val data: Data? = activity?.let { ViewModelProvider(it)[Data::class.java] }

        val userName = view.findViewById<TextView>(R.id.resultTitle)
        userName.text = data?.userName.toString()

        val correctAns = view.findViewById<TextView>(R.id.correct)
        correctAns.text = data?.userResult.toString()

        val tryAgainBtn = view.findViewById<Button>(R.id.tryAgain)
        tryAgainBtn.setOnClickListener {
            val fragment = StartFragment()
            val fragmentManager = activity?.supportFragmentManager
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.container, fragment)
            trans?.commit()
        }

        return view
    }

}