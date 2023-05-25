package com.example.quiz_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


class StartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_start, container, false)

        val name = view.findViewById<EditText>(R.id.username)

        val btn = view.findViewById<Button>(R.id.enterbtn)
        btn.setOnClickListener {
            if(name.text.toString() == "") {
                Toast.makeText(activity, "Please enter name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Entering to main screen", Toast.LENGTH_SHORT).show()
                val fragment = MainFragment()
                val fragmentManager = activity?.supportFragmentManager
                val trans = fragmentManager?.beginTransaction()
                trans?.replace(R.id.container, fragment)
                trans?.commit()
            }
        }

        return  view
    }


}