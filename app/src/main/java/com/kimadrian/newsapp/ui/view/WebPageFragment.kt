package com.kimadrian.newsapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kimadrian.newsapp.R
import com.kimadrian.newsapp.databinding.FragmentWebPageBinding

class WebPageFragment : Fragment() {

    lateinit var binding: FragmentWebPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWebPageBinding.inflate(inflater, container, false)

        var url: String
        arguments.let {
            val args = WebPageFragmentArgs.fromBundle(it!!)
            url = args.url
        }

        binding.progress.visibility = View.VISIBLE
        binding.webView.loadUrl(url)
        binding.webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progress.visibility = View.INVISIBLE
            }
        }

        activity?.onBackPressedDispatcher?.addCallback(requireActivity(), object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_webPageFragment_to_homeFragment)
            }
        })


        return binding.root
    }

}