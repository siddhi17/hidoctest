package com.example.hidoctest.Activities

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.hidoctest.R
import com.example.hidoctest.Adapters.ViewPagerAdapter
import com.example.hidoctest.Fragments.BooksFragment
import com.example.hidoctest.Fragments.NewsFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)

        setSupportActionBar(toolbar)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NewsFragment(), "News")
        adapter.addFragment(BooksFragment(), "Books")


        viewPager?.adapter = adapter

        tabs?.setupWithViewPager(viewPager)

    }
}