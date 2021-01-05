package com.example.hidoctest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hidoctest.Adapters.BooksAdapter
import com.example.hidoctest.Adapters.NewsAdapter
import com.example.hidoctest.R
import com.example.hidoctest.ViewModels.BooksViewModel
import com.example.hidoctest.ViewModels.NewsViewModel
import com.example.hidoctest.model.Item
import com.example.hidoctest.model.NewsArticle

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BooksFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var booksAdapter: BooksAdapter? = null
    var booksArrayList: ArrayList<Item> = ArrayList()
    var rvBooks: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_books, container, false)

        setUpUI(view)

        return view
    }


    private fun setUpUI(view: View)
    {
        rvBooks = view.findViewById(R.id.recyclerView)

        val booksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
        booksViewModel.init()
        booksViewModel.getBooksRepository()?.observe(this) { booksResponse ->

            val bookArticles: List<Item> = booksResponse?.items!!

            booksArrayList.addAll(bookArticles)

            booksAdapter?.notifyDataSetChanged()
        }

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        if (booksAdapter == null) {
            booksAdapter = context?.let { BooksAdapter(it, booksArrayList) }
            rvBooks?.layoutManager = LinearLayoutManager(context)
            rvBooks?.adapter = booksAdapter
            rvBooks?.itemAnimator = DefaultItemAnimator()
            rvBooks?.isNestedScrollingEnabled = true
        } else {
            booksAdapter!!.notifyDataSetChanged()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BooksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BooksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}