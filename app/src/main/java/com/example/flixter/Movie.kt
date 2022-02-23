package com.example.flixter

import org.json.JSONArray

data class Movie(val movieId: Int, private val posterPath: String, val title: String, val overview: String,) {
    val posterUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJsonArray(movieArray: JSONArray?): List<Movie> {
            val movies = mutableListOf<Movie>()
            if (movieArray != null) {
                for(i in 0 until movieArray.length()){
                    val movieJson = movieArray.getJSONObject(i)
                    movies.add(
                        Movie(
                            movieJson.getInt("id"),
                            movieJson.getString("poster_path"),
                            movieJson.getString("title"),
                            movieJson.getString("overview")
                        )
                    )
                }
            }
            return movies
        }
    }

}