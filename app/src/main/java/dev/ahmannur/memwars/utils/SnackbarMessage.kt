package dev.ahmannur.memwars.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object SnackbarMessage {
    fun showMessage(rootView: View, message: String, messageType: String){
        Log.i("VBS", message)
        val snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_INDEFINITE)
        snackbar.setDuration(5000)
        snackbar.show()
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}