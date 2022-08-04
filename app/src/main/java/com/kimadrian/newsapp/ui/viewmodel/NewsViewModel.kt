package com.kimadrian.newsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kimadrian.newsapp.data.repository.NewsRepository
import com.kimadrian.newsapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

private const val TAG = "NewsViewModel"

class NewsViewModel: ViewModel() {

    private val newsRepository = NewsRepository()


    fun getNews()  = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val response = newsRepository.getNews()
                if (response.isSuccessful && response.body() != null) {
                    emit(Resource.success(data = response.body()?.articles))
                }

        }catch (e: HttpException) {
            Log.e(TAG, "HttpException: ${e.message}")
            emit(Resource.error(data = null, message = "HttpException: ${e.message}"))
        } catch (e: ClassCastException) {
            Log.e(TAG, "ClassCastException: ${e.message}")
        } catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}")
            emit(Resource.error(data = null, message = "Exception: ${e.message}"))
        }
    }


}