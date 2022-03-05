package com.example.flixter

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray

@Parcelize
data class Movie(val movieId: Int, val voteAverage: Double, private val posterPath: String, val title: String, val overview: String,) : Parcelable {
    @IgnoredOnParcel
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
                            movieJson.getDouble("vote_average"),
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