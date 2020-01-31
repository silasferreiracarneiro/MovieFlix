package br.com.silas.carneiro.movieflix.utils

import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Base64
import java.util.Collections.replaceAll



class Base64Util {

    companion object {
        fun encode(text: String): String {
            return Base64.encodeToString(text.toByteArray(), Base64.NO_WRAP)
        }

        fun decode(text: String): String {
            return String(Base64.decode(text, Base64.DEFAULT))
        }

        fun encodeByte(array: ByteArray): String {
            return Base64.encodeToString(array, Base64.DEFAULT)
        }

        fun decodeBase64ToByte(base64: String): ByteArray {
            return Base64.decode(base64, Base64.DEFAULT)
        }

        fun decodebase64InBitmap(array: ByteArray): Bitmap {
            return BitmapFactory.decodeByteArray(array, 0, array.size)
        }
    }
}