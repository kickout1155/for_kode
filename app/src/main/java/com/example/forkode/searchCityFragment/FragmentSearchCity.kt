package com.example.forkode.searchCityFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.forkode.R

class FragmentSearchCity : Fragment() {

    val viewModel by lazy { ViewModelProvider(this).get(ViewModelSearchFragment::class.java) }

    lateinit var tv_city: AutoCompleteTextView
    //lateinit var tv_airport : AppCompatTextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_city, container, false)
        tv_city = view.findViewById(R.id.search_city)



        return view
    }
}