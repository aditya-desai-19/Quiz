package com.example.quiz_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


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

        val data: Data? = activity?.let { ViewModelProvider(it)[Data::class.java] }

        val options1 = arrayListOf<String>("HTML", "Python", "MongoDb", "MongoDb", "Pycharm")
        val options2 = arrayListOf<String>("Java", "C", "MySQL", "Oracle", "Windows")
        val answers = arrayOf("HTML","Python","MySQL", "MongoDb","Pycharm")
        var result = 0

        val prevbtn = view.findViewById<Button>(R.id.prevbtn)
        val nextbtn = view.findViewById<Button>(R.id.nextbtn)
        val submitbtn = view.findViewById<Button>(R.id.submitbtn)

        prevbtn.setOnClickListener {
            val questionstr = "q$currentquestion"
            val questionint = this.resources.getIdentifier(questionstr, "id", "com.example.quiz_app" )
            val question = view.findViewById<TextView>(questionint)
            val radioBtn1 = view.findViewById<RadioButton>(R.id.rb1)
            val radioBtn2 = view.findViewById<RadioButton>(R.id.rb2)
            question.alpha = 0f

            if(radioBtn1.isChecked || radioBtn2.isChecked) {
                val enteredAnswer: String
                if(radioBtn1.isChecked) {
                    enteredAnswer = radioBtn1.text.toString()
                } else {
                    enteredAnswer = radioBtn2.text.toString()
                }

                if(enteredAnswer == answers[currentquestion-1]) {
                    result += 1
                }

                currentquestion -= 1

                val prevquestionstr = "q$currentquestion"
                val prevquestionint = this.resources.getIdentifier(prevquestionstr, "id", "com.example.quiz_app")
                val prevquestion = view.findViewById<TextView>(prevquestionint)
                radioBtn1.text = options1[currentquestion-1]
                radioBtn2.text = options2[currentquestion-1]
                prevquestion.alpha = 1f
            }

        }

        nextbtn.setOnClickListener {
            val questionstr = "q$currentquestion"
            val questionint = this.resources.getIdentifier(questionstr, "id", "com.example.quiz_app" )
            val question = view.findViewById<TextView>(questionint)
            val  radioBtn1 = view.findViewById<RadioButton>(R.id.rb1)
            val  radioBtn2 = view.findViewById<RadioButton>(R.id.rb2)
            question.alpha = 0f

            if(radioBtn1.isChecked || radioBtn2.isChecked) {
                val enteredAnswer: String
                if(radioBtn1.isChecked) {
                    enteredAnswer = radioBtn1.text.toString()
                } else {
                    enteredAnswer = radioBtn2.text.toString()
                }

                if(enteredAnswer == answers[currentquestion-1]) {
                    result += 1
                }

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
                radioBtn1.text = options1[currentquestion-1]
                radioBtn2.text = options2[currentquestion-1]
                nextquestion.alpha = 1f
            } else {
                val questionStill = view.findViewById<TextView>(questionint)
                val  radioBtn1Still = view.findViewById<RadioButton>(R.id.rb1)
                val  radioBtn2Still = view.findViewById<RadioButton>(R.id.rb2)
                questionStill.alpha = 1f
                Toast.makeText(activity, "Please select one answer", Toast.LENGTH_SHORT).show()
            }
        }

        submitbtn.setOnClickListener {
            data?.userResult = result
            val fragment = ResultFragment()
            val fragmentManager = activity?.supportFragmentManager
            val trans = fragmentManager?.beginTransaction()
            trans?.replace(R.id.container, fragment)
            trans?.commit()
        }

        return view
    }

}