package com.example.flixter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val movietitle=itemView.findViewById<TextView>(R.id.movietitle)
        private val movieid=itemView.findViewById<ImageView>(R.id.poster)
        private val movieoverview=itemView.findViewById<TextView>(R.id.movieoverview)
        fun bind(movie: Movie){
            movietitle.text = movie.title
            movieoverview.text = movie.overview
            Glide.with(context).load(movie.posterUrl).into(movieid)

        }
    }
}
