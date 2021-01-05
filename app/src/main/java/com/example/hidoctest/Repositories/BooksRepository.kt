package com.example.hidoctest.Repositories

import androidx.lifecycle.MutableLiveData
import com.example.hidoctest.Networking.Api
import com.example.hidoctest.Networking.RetrofitService
import com.example.hidoctest.model.BooksResponse
import com.example.hidoctest.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository {

    private val api: Api = RetrofitService.bookService(Api::class.java)

    fun getBooks(): MutableLiveData<BooksResponse?> {
        val booksData = MutableLiveData<BooksResponse?>()
        api.getBooksList()!!.enqueue(object : Callback<BooksResponse?> {
            override fun onResponse(
                call: Call<BooksResponse?>?,
                response: Response<BooksResponse?>
            ) {
                if (response.isSuccessful) {
                    booksData.value = response.body()
                }
            }

            override fun onFailure(call: Call<BooksResponse?>?, t: Throwable?) {
                booksData.value = null
            }
        })
        return booksData
    }

    companion object {
        private var booksRepository: BooksRepository? = null
        val instance: BooksRepository?
            get() {
                if (booksRepository == null) {
                    booksRepository = BooksRepository()
                }
                return booksRepository
            }
    }
}