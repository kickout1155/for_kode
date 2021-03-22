package com.example.forkode.searchCityFragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forkode.OnViewHolderClickListener
import com.example.forkode.R
import com.example.forkode.adapterWeather.AdapterCity

class FragmentSearchCity : Fragment() {

    val viewModel by lazy { ViewModelProvider(this).get(ViewModelSearchFragment::class.java) }

    lateinit var toolbar: Toolbar
    lateinit var tv_city: AppCompatEditText
    lateinit var tv_selectPoint: AppCompatTextView
    lateinit var rv_recycler: RecyclerView

    val adapter = AdapterCity()

    var hintCity: String = ""
    var textPoint: String = ""

    companion object {
        fun newInstance(hintCity: String, textPoint: String): FragmentSearchCity {
            val args = Bundle()
            args.putString("hintCity", hintCity)
            args.putString("textPoint", textPoint)
            val fragment = FragmentSearchCity()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hintCity = arguments?.getString("hintCity") ?: ""
        textPoint = arguments?.getString("textPoint") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_city, container, false)
        tv_city = view.findViewById(R.id.search_city)
        tv_selectPoint = view.findViewById(R.id.select_point)
        toolbar = view.findViewById(R.id.toolbar)
        rv_recycler = view.findViewById(R.id.recycler_city)

        initUi()
        observers()
        setListeners()

        return view
    }

    private fun observers() {
        viewModel.listCity.observe(viewLifecycleOwner, {
            adapter.addAndNotify(it)
        })
    }

    private fun setListeners() {
        adapter.setOnClickListener(object : OnViewHolderClickListener {
            override fun onClick(position: Int) {
                val item = adapter.getItem(position)
                val bundle = Bundle()
                bundle.putSerializable("city", item)
                setFragmentResult(hintCity, bundle)
                activity?.onBackPressed()
            }
        })
    }

    private fun initUi() {
        tv_city.hint = hintCity
        tv_selectPoint.text = textPoint
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_recycler.layoutManager = layoutManager
        rv_recycler.adapter = adapter
    }
}