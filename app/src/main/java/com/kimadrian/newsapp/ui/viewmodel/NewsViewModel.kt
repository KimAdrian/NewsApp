package com.kimadrian.newsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimadrian.newsapp.data.model.Article
import com.kimadrian.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

private const val TAG = "NewsViewModel"

class NewsViewModel: ViewModel() {

    private val newsRepository = NewsRepository()
    var newsArticles = MutableLiveData<List<Article>?>()

    init {
        getNews()
    }


    private fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = newsRepository.getNews()
                if (response.isSuccessful && response.body() != null){
                    newsArticles.postValue(response.body()?.articles)
                }
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException: ${e.message}")
            } catch (e: ClassCastException) {
                Log.e(TAG, "ClassCastException: ${e.message}")
            } catch (e: Exception) {
                Log.e(TAG, "Exception: ${e.message}",)
            }
        }

    }



}