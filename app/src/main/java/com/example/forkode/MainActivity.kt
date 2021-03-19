package com.example.forkode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.forkode.mainFragment.FragmentMain
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainFragment = FragmentMain.newInstance()
        replaceFragment(mainFragment, "mainFragment")
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(tag)
            .commit()
    }
}