package com.example.forkode.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.forkode.EnterFragment
import com.example.forkode.R
import com.example.forkode.Ticket
import com.example.forkode.searchCityFragment.FragmentSearchCity
import com.example.forkode.weatherFragment.FragmentWeather
import com.google.android.material.textview.MaterialTextView

class FragmentMain : Fragment() {

    val viewModel by lazy {
        ViewModelProvider(this, ViewModelMainFragmentFactory(Ticket())).get(
            ViewModelMainFragment::class.java
        )
    }

    lateinit var ll_fromWhere: LinearLayoutCompat
    lateinit var tv_fromWhereCity: MaterialTextView
    lateinit var tv_fromWhereAirport: MaterialTextView

    lateinit var ll_where: LinearLayoutCompat
    lateinit var tv_whereCity: TextView
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
    lateinit var tv_titleAdult: MaterialTextView
    lateinit var btn_deleteAdultTicket: AppCompatImageButton

    lateinit var btn_addKidTicket: AppCompatImageButton
    lateinit var tv_countKidTickets: MaterialTextView
    lateinit var tv_titleKid: MaterialTextView
    lateinit var btn_deleteKidTicket: AppCompatImageButton

    lateinit var btn_addBabyTicket: AppCompatImageButton
    lateinit var tv_countBabyTickets: MaterialTextView
    lateinit var tv_titleBaby: MaterialTextView
    lateinit var btn_deleteBabyTicket: AppCompatImageButton

    lateinit var btn_findFlight: AppCompatButton


    companion object {
        fun newInstance(): FragmentMain {
            return FragmentMain()
        }
    }

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
//        btn_clearBackDate = view.findViewById(R.id.clear_date_back)

        btn_addAdultTicket = view.findViewById(R.id.add_adult_ticket)
        tv_countAdultTickets = view.findViewById(R.id.count_adult_tickets)
        tv_titleAdult = view.findViewById(R.id.title_adult)
        btn_deleteAdultTicket = view.findViewById(R.id.delete_adult_ticket)

        btn_addKidTicket = view.findViewById(R.id.add_kid_ticket)
        tv_countKidTickets = view.findViewById(R.id.count_kid_tickets)
        tv_titleKid = view.findViewById(R.id.title_kid)
        btn_deleteKidTicket = view.findViewById(R.id.delete_kid_ticket)

        btn_addBabyTicket = view.findViewById(R.id.add_baby_ticket)
        tv_countBabyTickets = view.findViewById(R.id.count_baby_tickets)
        tv_titleBaby = view.findViewById(R.id.title_baby)
        btn_deleteBabyTicket = view.findViewById(R.id.delete_baby_ticket)

        btn_findFlight = view.findViewById(R.id.find_flight)

    }

    private fun setFirstValues() {
        tv_titleThereDate.text = "Туда"
        tv_thereDate.text = "Тек дата"

        tv_titleBackDate.text = "Обратно"
        tv_backDate.text = "другая дата"

        tv_titleAdult.text = "Взрослый"
        tv_titleKid.text = "2-12 лет"
        tv_titleBaby.text = "до 2-х лет"

        btn_findFlight.text = "Найти рейсы"
    }

    private fun setObservers() {
        viewModel.fromWhereCity.observe(viewLifecycleOwner, { city ->
            tv_fromWhereCity.text = city?.name
        })

        viewModel.fromWhereAirport.observe(viewLifecycleOwner, { airport ->
            tv_fromWhereAirport.text = airport?.name
        })

        viewModel.whereCity.observe(viewLifecycleOwner, { city ->
            tv_whereCity.text = city?.name
        })

        viewModel.whereAirport.observe(viewLifecycleOwner, { airport ->
            tv_whereAirport.text = airport?.name
        })

        viewModel.countAdultTickets.observe(viewLifecycleOwner, { countTicket ->
            tv_countAdultTickets.text = countTicket.toString()
        })
        viewModel.countKidTickets.observe(viewLifecycleOwner, { countTicket ->
            tv_countKidTickets.text = countTicket.toString()
        })
        viewModel.countBabyTickets.observe(viewLifecycleOwner, { countTicket ->
            tv_countBabyTickets.text = countTicket.toString()
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

        btn_addKidTicket.setOnClickListener {
            viewModel.addKidTicket()
        }

        btn_addBabyTicket.setOnClickListener {
            viewModel.addBabyTicket()
        }

        btn_deleteAdultTicket.setOnClickListener {
            viewModel.deleteAdultTicket()
        }

        btn_deleteKidTicket.setOnClickListener {
            viewModel.deleteKidTicket()
        }

        btn_deleteBabyTicket.setOnClickListener {
            viewModel.deleteBabyTicket()
        }

        ll_where.setOnClickListener {

        }

        ll_fromWhere.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, FragmentSearchCity())
                ?.addToBackStack(null)
                ?.commit()
        }

        ll_there.setOnClickListener {

        }

        ll_back.setOnClickListener {

        }



        btn_findFlight.setOnClickListener {

            val activityFragment = activity

            activityFragment ?: return@setOnClickListener

            val fragmentWeather = FragmentWeather.newInstance(
                viewModel.fromWhereCity.value,
                viewModel.whereCity.value
            )

            activityFragment.supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragmentWeather)
                .addToBackStack(null)
                .commit()
        }
    }


}