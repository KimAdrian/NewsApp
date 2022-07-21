package com.kimadrian.newsapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimadrian.newsapp.databinding.FragmentHomeBinding
import com.kimadrian.newsapp.ui.adapter.RecyclerViewAdapter
import com.kimadrian.newsapp.ui.viewmodel.NewsViewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val TAG = "HomeFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val viewModel = NewsViewModel()

        val adapter = RecyclerViewAdapter()
        viewModel.newsArticles.observe(viewLifecycleOwner){
            adapter.submitList(it)
            if (adapter.itemCount>0){
                    binding.progress.visibility = View.INVISIBLE
            }

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter


        activity?.onBackPressedDispatcher?.addCallback(requireActivity(), object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        })


        return binding.root
    }

}