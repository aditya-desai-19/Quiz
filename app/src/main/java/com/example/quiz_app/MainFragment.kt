package com.example.quiz_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast


class MainFragment : Fragment() {
    var currentquestion = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        val options1 = arrayListOf<String>("HTML", "Python", "MongoDb", "MongoDb", "Pycharm")
        val options2 = arrayListOf<String>("Java", "C", "MySQL", "Oracle", "Windows")

        val prevbtn = view.findViewById<Button>(R.id.prevbtn)
        val nextbtn = view.findViewById<Button>(R.id.nextbtn)
        val submitbtn = view.findViewById<Button>(R.id.submitbtn)

        prevbtn.setOnClickListener {
            val questionstr = "q$currentquestion"
            val questionint = this.resources.getIdentifier(questionstr, "id", "com.example.quiz_app" )
            val question = view.findViewById<TextView>(questionint)
            val checkbox1 = view.findViewById<CheckBox>(R.id.chk1)
            val checkbox2 = view.findViewById<CheckBox>(R.id.chk2)
            question.alpha = 0f

            currentquestion -= 1

            val prevquestionstr = "q$currentquestion"
            val prevquestionint = this.resources.getIdentifier(prevquestionstr, "id", "com.example.quiz_app")
            val prevquestion = view.findViewById<TextView>(prevquestionint)
            checkbox1.text = options1[currentquestion-1]
            checkbox2.text = options2[currentquestion-1]
            prevquestion.alpha = 1f
        }

        nextbtn.setOnClickListener {
            val questionstr = "q$currentquestion"
            val questionint = this.resources.getIdentifier(questionstr, "id", "com.example.quiz_app" )
            val question = view.findViewById<TextView>(questionint)
            val checkbox1 = view.findViewById<CheckBox>(R.id.chk1)
            val checkbox2 = view.findViewById<CheckBox>(R.id.chk2)
            question.alpha = 0f

            currentquestion += 1

            if(currentquestion > 1 && currentquestion < 5) {
                prevbtn.visibility = View.VISIBLE
            } else {
                prevbtn.visibility = View.GONE
            }

            if(currentquestion == 5) {
                currentquestion = 5
                nextbtn.visibility = View.GONE
                submitbtn.visibility = View.VISIBLE
            }

            val nextquestionstr = "q$currentquestion"
            val nextquestionint = this.resources.getIdentifier(nextquestionstr, "id", "com.example.quiz_app")
            val nextquestion = view.findViewById<TextView>(nextquestionint)
            checkbox1.text = options1[currentquestion-1]
            checkbox2.text = options2[currentquestion-1]
            nextquestion.alpha = 1f
        }

        submitbtn.setOnClickListener {
            val fragment = ResultFragment()
            val fragmentManager = activity?.supportFragmentManager
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.container, fragment)
            trans?.commit()
        }

        return view
    }

}