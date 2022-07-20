package com.kimadrian.newsapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimadrian.newsapp.R
import com.kimadrian.newsapp.data.model.Article
import com.kimadrian.newsapp.data.model.NewsResponse
import com.kimadrian.newsapp.data.repository.NewsRepository
import com.kimadrian.newsapp.databinding.FragmentHomeBinding
import com.kimadrian.newsapp.ui.adapter.RecyclerViewAdapter
import com.kimadrian.newsapp.ui.viewmodel.NewsViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.math.log

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val TAG = "HomeFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val adapter = RecyclerViewAdapter()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.progress.visibility = View.VISIBLE
        lifecycleScope.launch {
            try {
                adapter.submitList(NewsRepository().getNews().body()?.articles)
                if (adapter.itemCount>0){
                    binding.progress.visibility = View.INVISIBLE
                }
                //binding.statsResponse.text = NewsRepository().getNews().body()?.articles.toString()
            }catch (e: HttpException){
                Log.e(TAG, "HttpException: ${e.message}")
            } catch (e: ClassCastException){
                Log.e(TAG, "ClassCastException: ${e.message}")
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