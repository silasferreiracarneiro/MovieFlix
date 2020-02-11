package br.com.silas.carneiro.movieflix.utils

class AppConstant {

    companion object {
        //PREFERENCES
        val PREF_NAME: String = "PREFS"
        val FIRST_LOGIN: String = "FIRST_LOGIN"

        //FIREBASE
        val USER: String = "USER"

        //INTENT
        val ITEM_SEARCH_MOVIE = "ITEMMOVIE"

        //API THE MOVIE
        val URL_BASE: String = "https://api.themoviedb.org/3/"
        val API_KEY = "636e794de4bf9df335e693bb65085e65"
        val TOKEN_READ_API = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MzZlNzk0ZGU0YmY5ZGYzMzVlNjkzYmI2NTA4NWU2NSIsInN1YiI6IjVjYTU0MzFiOTI1MTQxNWVhZjZiN2EyOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XgaICKcUqIIf1RiN4LakNISw42S5lNV4vrKZTP66nXQ"
        val MOVIE_ID = 550

        val URL_IMG = "https://image.tmdb.org/t/p/w500"
        val URL_IMG_DETAIL = "https://image.tmdb.org/t/p/original"
    }
}