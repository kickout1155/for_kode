package com.example.forkode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textview.MaterialTextView

class FragmentMain : Fragment() {

    val viewModel by lazy { ViewModelProvider(this,ViewModelMainFragmentFactory(Ticket())).get(ViewModelMainFragment::class.java) }

    lateinit var ll_fromWhere: LinearLayoutCompat
    lateinit var tv_fromWhereCity: MaterialTextView
    lateinit var tv_fromWhereAirport: MaterialTextView

    lateinit var ll_where: LinearLayoutCompat
    lateinit var tv_whereCity: MaterialTextView
    lateinit var tv_whereAirport: MaterialTextView

    lateinit var btn_reverse: AppCompatImageButton

    lateinit var ll_there: LinearLayoutCompat
    lateinit var tv_titleThereDate: MaterialTextView
    lateinit var tv_thereDate: MaterialTextView

    lateinit var ll_back: LinearLayoutCompat
    lateinit var tv_titleBackDate: MaterialTextView
    lateinit var tv_backDate: MaterialTextView
    lateinit var btn_clearBackDate: AppCompatImageButton

    lateinit var btn_addAdultTicket: AppCompatImageButton
    lateinit var tv_countAdultTickets: MaterialTextView
    lateinit var btn_deleteAdultTicket: AppCompatImageButton

    val DEFAULT_COUNT = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initView(view)
        setFirstValues()
        setObservers()
        setClickListeners()
        return view
    }

    private fun initView(view: View) {
        ll_fromWhere = view.findViewById(R.id.linearlayout_section_from_where)
        tv_fromWhereCity = view.findViewById(R.id.from_where_city)
        tv_fromWhereAirport = view.findViewById(R.id.from_where_airport)

        ll_where = view.findViewById(R.id.linearlayout_section_where)
        tv_whereCity = view.findViewById(R.id.where_city)
        tv_whereAirport = view.findViewById(R.id.where_airport)

        btn_reverse = view.findViewById(R.id.reverse)

        ll_there = view.findViewById(R.id.linearlayout_section_there)
        tv_titleThereDate = view.findViewById(R.id.title_there_date)
        tv_thereDate = view.findViewById(R.id.there_date)

        ll_back = view.findViewById(R.id.linearlayout_section_back)
        tv_titleBackDate = view.findViewById(R.id.title_back_date)
        tv_backDate = view.findViewById(R.id.back_date)
        btn_clearBackDate = view.findViewById(R.id.clear_date_back)

        btn_addAdultTicket = view.findViewById(R.id.add_adult_ticket)
        tv_countAdultTickets = view.findViewById(R.id.count_adult_tickets)
        btn_deleteAdultTicket = view.findViewById(R.id.delete_adult_ticket)
    }

    private fun setFirstValues() {
        tv_titleThereDate.text = "Туда"
        tv_thereDate.text = "Тек дата"

        tv_titleBackDate.text = "Обратно"
        tv_backDate.text = "другая дата"
    }

    private fun setObservers() {
        viewModel.fromWhereCity.observe(viewLifecycleOwner, { nameCity ->
            tv_fromWhereCity.text = nameCity
        })

        viewModel.fromWhereAirport.observe(viewLifecycleOwner, { nameAirport ->
            tv_fromWhereAirport.text = nameAirport
        })

        viewModel.whereCity.observe(viewLifecycleOwner, { nameCity ->
            tv_whereCity.text = nameCity
        })

        viewModel.whereAirport.observe(viewLifecycleOwner, { nameAirport ->
            tv_whereAirport.text = nameAirport
        })

        viewModel.countAdultTickets.observe(viewLifecycleOwner, { countTicket ->
            tv_countAdultTickets.text = countTicket.toString()
        })

        viewModel.message.observe(viewLifecycleOwner, { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })


    }

    private fun setClickListeners() {
        btn_reverse.setOnClickListener {
            viewModel.reversClick()
        }

        btn_addAdultTicket.setOnClickListener {
            viewModel.addAdultTicket()
        }

        btn_deleteAdultTicket.setOnClickListener {
            viewModel.deleteAdultTicket()
        }
    }


}