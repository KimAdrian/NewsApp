package com.kimadrian.newsapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kimadrian.newsapp.R
import com.kimadrian.newsapp.databinding.FragmentWebPageBinding

class WebPageFragment : Fragment() {

    lateinit var binding: FragmentWebPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWebPageBinding.inflate(inflater, container, false)



        return binding.root
    }

}