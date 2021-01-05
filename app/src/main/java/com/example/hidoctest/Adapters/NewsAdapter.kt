package com.example.hidoctest.Adapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hidoctest.R
import com.example.hidoctest.model.NewsArticle
import com.squareup.picasso.Picasso


class NewsAdapter(context: Context, articles: ArrayList<NewsArticle>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var context: Context = context
    var articles: ArrayList<NewsArticle> = articles

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.tvName.setText(articles[position].title)
        holder.tvDescription.text = Html.fromHtml(Html.fromHtml(articles[position].description).toString())
        holder.tvPublishedDate.setText(articles[position].publishedAt)

   /*     val aUrl: String = articles[position].url.replace("http", "https")

        Picasso
            .get()
            .load(aUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fit()
            .into(holder.ivNews)*/
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        var tvPublishedDate: TextView = itemView.findViewById(R.id.tvPublishedDate)

    }

}