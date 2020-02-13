package br.com.silas.carneiro.movieflix.utils

import java.text.SimpleDateFormat
import java.util.*

val format: SimpleDateFormat = SimpleDateFormat("dd/MMM/yyyy")

fun Date.convertDate(): String {
    if(this != null){
        return format.format(this)
    }
    return ""
}