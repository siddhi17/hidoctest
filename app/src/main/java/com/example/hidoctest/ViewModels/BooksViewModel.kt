package com.example.hidoctest.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hidoctest.Repositories.BooksRepository
import com.example.hidoctest.Repositories.NewsRepository
import com.example.hidoctest.model.BooksResponse
import com.example.hidoctest.model.NewsResponse

class BooksViewModel : ViewModel() {
        private var mutableLiveData: MutableLiveData<BooksResponse?>? = null
        private var booksRepository: BooksRepository? = null
        fun init() {
            if (mutableLiveData != null) {
                return
            }
            booksRepository = BooksRepository.instance
            mutableLiveData = booksRepository!!.getBooks()
        }

        fun getBooksRepository(): LiveData<BooksResponse?>? {
            return mutableLiveData
        }
}