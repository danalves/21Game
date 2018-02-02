package com.daniloalvesvieira.a21game.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.daniloalvesvieira.a21game.R


/**
 * A simple [Fragment] subclass.
 */
class SobreFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater!!.inflate(R.layout.fragment_sobre, container, false)

        return view

    }

}// Required empty public constructor
