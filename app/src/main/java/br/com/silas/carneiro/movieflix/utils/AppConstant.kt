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
        val VIDEO_ID = "VIDEOID"

        //API THE MOVIE
        val URL_BASE: String = "https://api.themoviedb.org/3/"
        val API_KEY = "636e794de4bf9df335e693bb65085e65"
        val URL_IMG = "https://image.tmdb.org/t/p/w500"
        val URL_IMG_DETAIL = "https://image.tmdb.org/t/p/original"
    }
}