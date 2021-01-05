package com.example.hidoctest.ViewModels

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.hidoctest.Repositories.NewsRepository
import com.example.hidoctest.model.NewsResponse


class NewsViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<NewsResponse?>? = null
    private var newsRepository: NewsRepository? = null
    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsRepository = NewsRepository.instance
        mutableLiveData = newsRepository!!.getNews("google-news", "922b18cb7b5542e08719816a45bb1474")
    }

    fun getNewsRepository(): LiveData<NewsResponse?>? {
        return mutableLiveData
    }
}