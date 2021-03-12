package com.example.forkode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment

class FragmentMain : Fragment() {

    lateinit var linearFromWhere: LinearLayoutCompat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)
        linearFromWhere = view.findViewById(R.id.linearlayout_from_where)
        linearFromWhere.setOnClickListener {

        }
        return view
    }
}