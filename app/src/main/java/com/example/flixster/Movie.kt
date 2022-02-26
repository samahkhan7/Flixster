package com.example.flixster

import org.json.JSONArray

// main purpose is to bundle pieces of data (such as the title, overview, image url)
data class Movie(
    val movieID: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
)   {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}