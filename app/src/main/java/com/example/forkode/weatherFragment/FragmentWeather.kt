package com.example.forkode.weatherFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forkode.R
import com.example.forkode.adapterWeather.AdapterWeatherDetail
import com.example.forkode.model.City
import com.example.forkode.network.Repository
import com.example.forkode.network.RetrofitBuilder
import com.example.forkode.network.WeatherApiHelper
import com.google.android.material.textview.MaterialTextView

class FragmentWeather : Fragment() {

    lateinit var viewModel: ViewModelWeatherFragment

    lateinit var ll_fromWhereWeatherContainer: LinearLayout
    lateinit var ll_whereWeatherContainer: LinearLayout
    lateinit var tv_titleBack: MaterialTextView
    lateinit var tv_titleThere: MaterialTextView
    lateinit var tv_toolBarCityFromWhere : MaterialTextView
    lateinit var tv_toolBarCityWhere : MaterialTextView

    lateinit var rv_fromWhereWeather: RecyclerView
    val adapterFromWhereWeather = AdapterWeatherDetail()

    lateinit var rv_whereWeather: RecyclerView
    val adapterWhereWeather = AdapterWeatherDetail()


    companion object {
        fun newInstance(cityFromWhere: City?, cityWhere: City?): FragmentWeather {
            val args = Bundle()
            args.putSerializable("cityFromWhere", cityFromWhere)
            args.putSerializable("cityWhere", cityWhere)
            val fragment = FragmentWeather()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cityFromWhere: City = arguments?.getSerializable("cityFromWhere") as City
        val cityWhere: City = arguments?.getSerializable("cityWhere") as City
        val repository = Repository(WeatherApiHelper(RetrofitBuilder.weatherApi))
        viewModel =
            ViewModelProvider(
                this, ViewModelWeatherFragmentFactory(
                    cityFromWhere,
                    cityWhere,
                    repository
                )
            ).get(
                ViewModelWeatherFragment::class.java
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        ll_fromWhereWeatherContainer = view.findViewById(R.id.container_title_there)
        ll_whereWeatherContainer = view.findViewById(R.id.container_title_back)
        tv_titleThere = view.findViewById(R.id.title_there)
        tv_titleBack = view.findViewById(R.id.title_back)
        rv_fromWhereWeather = view.findViewById(R.id.recycler_from_where_weather)
        rv_whereWeather = view.findViewById(R.id.recycler_where_weather)
        tv_toolBarCityFromWhere = view.findViewById(R.id.name_city_from_where)
        tv_toolBarCityWhere = view.findViewById(R.id.name_city_where)


        initUi()
        observers()
        setClickListeners()
        viewModel.downloadWeather()
        return view
    }

    private fun initUi() {
        val layoutManagerFromWhereWeather = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val layoutManagerWhereWeather = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_fromWhereWeather.adapter = adapterFromWhereWeather
        rv_fromWhereWeather.layoutManager = layoutManagerFromWhereWeather
        rv_whereWeather.adapter = adapterWhereWeather
        rv_whereWeather.layoutManager = layoutManagerWhereWeather

        rv_fromWhereWeather.visibility = View.VISIBLE
        rv_whereWeather.visibility = View.GONE

        tv_titleThere.text = "Туда"
        tv_titleBack.text = "Обратно"
    }

    private fun setClickListeners() {

        ll_fromWhereWeatherContainer.setOnClickListener {
            rv_fromWhereWeather.visibility = View.VISIBLE
            rv_whereWeather.visibility = View.GONE
        }

        ll_whereWeatherContainer.setOnClickListener {
            rv_fromWhereWeather.visibility = View.GONE
            rv_whereWeather.visibility = View.VISIBLE
        }
    }

    private fun observers() {
        viewModel.cityFromWhere.observe(viewLifecycleOwner, { cityFromWhere ->
            tv_toolBarCityFromWhere.text = cityFromWhere.name
        })

        viewModel.cityWhere.observe(viewLifecycleOwner, { cityWhere ->
            tv_toolBarCityWhere.text = cityWhere.name
        })

        viewModel.listFromWhereWeather.observe(viewLifecycleOwner, { listDetailWeather ->
            adapterFromWhereWeather.clear()
            adapterFromWhereWeather.addAndNotify(listDetailWeather)
        })

        viewModel.listWhereWeather.observe(viewLifecycleOwner, { listDetailWeather ->
            adapterWhereWeather.clear()
            adapterWhereWeather.addAndNotify(listDetailWeather)
        })
    }


}