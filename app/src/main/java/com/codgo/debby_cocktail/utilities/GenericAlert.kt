package com.codgo.debby_cocktail.utilities

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.codgo.debby_cocktail.R
import com.robertlevonyan.components.kex.set

var alertDialogGlobal : AlertDialog? = null

fun Fragment.genericAlert(cancelable : Boolean, message : String, textxButton : String) {

    val alertDialog = AlertDialog.Builder(requireContext())
    val view : View = LayoutInflater.from(context).inflate(R.layout.generic_alert, null)
    alertDialog.setView(view)
    alertDialog.setCancelable(cancelable)
    alertDialogGlobal = alertDialog.create()
    alertDialogGlobal!!.window!!.setBackgroundDrawable(ColorDrawable(Color.BLUE))
    val message_alert = view.findViewById<TextView>(R.id.message_alert)
    val button_alert = view.findViewById<Button>(R.id.button_alert)
    message_alert.set(message)
    button_alert.set(textxButton)
    button_alert.setOnClickListener{ alertDialogGlobal!!.dismiss()}
    alertDialogGlobal!!.show()

}