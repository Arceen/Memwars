package dev.ahmannur.memwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import dev.ahmannur.memwars.R
import dev.ahmannur.memwars.utils.UserAuth

class IntroductionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_introduction, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val greetingsTV: TextView = view.findViewById(R.id.greetingsTextView)
        greetingsTV.text = "Hello, "+UserAuth.getUserEmail().toString()
    }
}