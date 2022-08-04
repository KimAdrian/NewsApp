package com.kimadrian.newsapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.kimadrian.newsapp.databinding.FragmentHomeBinding
import com.kimadrian.newsapp.ui.adapter.RecyclerViewAdapter
import com.kimadrian.newsapp.ui.viewmodel.NewsViewModel
import com.kimadrian.newsapp.utils.Status

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

        viewModel.getNews().observe(viewLifecycleOwner){
            it?.let {resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        resource.data.let { newsArticles ->
                            adapter.submitList(newsArticles)
                            if (adapter.itemCount>0){
                                binding.progress.visibility = View.INVISIBLE
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.progress.visibility = View.INVISIBLE
                        binding.errorImage.visibility = View.VISIBLE
                        Snackbar.make(binding.root, it.message.toString(), Snackbar.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progress.visibility = View.VISIBLE
                    }

                }

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