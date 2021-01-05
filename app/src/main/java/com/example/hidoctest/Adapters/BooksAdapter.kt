package com.example.hidoctest.Adapters

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.hidoctest.R
import com.example.hidoctest.model.Item
import com.squareup.picasso.Picasso


class BooksAdapter(context: Context, bookItem: ArrayList<Item>) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    var context: Context = context
    var books: ArrayList<Item> = bookItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.books_layout, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.tvName.setText(books[position].volumeInfo.title)
        holder.tvDescription.text = Html.fromHtml(
            Html.fromHtml(books[position].volumeInfo.description).toString()
        )
        holder.tvPublisher.setText(books[position].volumeInfo.publisher)

        val aUrl: String = books[position].volumeInfo.imageLinks
            .smallThumbnail.replace("http", "https")

        Picasso
            .get()
            .load(aUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fit()
            .into(holder.ivBook)

        val largeUrl: String = books[position].volumeInfo.imageLinks
            .thumbnail.replace("http", "https")

        Picasso
            .get()
            .load(largeUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fit()
            .into(holder.ivBookLarge)
       // Picasso.get().load().into(holder.ivNews)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    inner class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        var tvPublisher: TextView = itemView.findViewById(R.id.tvPublisher)
        var ivBook: AppCompatImageView = itemView.findViewById(R.id.ivBook)
        var ivBookLarge: AppCompatImageView = itemView.findViewById(R.id.bookImg)

    }
}