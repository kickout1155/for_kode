package com.example.forkode

import androidx.fragment.app.Fragment
import java.io.Serializable

interface EnterFragment : Serializable {

    fun replaceFragment(fragment: Fragment, tag: String)

}