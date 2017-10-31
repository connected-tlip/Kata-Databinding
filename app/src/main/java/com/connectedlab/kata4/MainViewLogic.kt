package com.connectedlab.kata4

import android.databinding.Observable
import android.databinding.ObservableField
import android.util.Log
import android.view.View

class MainViewLogic(val service: EmailService) : EmailService.Callback {

    val inputTextValue = ObservableField("")
    val errorTextVisible = ObservableField(false)
    val seekBarValue = ObservableField(0)
    val emailNumbers = ObservableField("")
    val errorTextValue = ObservableField("")

    init {
        inputTextValue.onChanged { newValue ->
            Log.d(TAG, "Input Text: $newValue")
            errorTextVisible.set(!newValue.contains("@"))
        }


        seekBarValue.onChanged {
            newValue -> Log.d(TAG, "Progress changed to: $newValue")

            emailNumbers.set("Number of emails: $newValue")
        }


    }

    fun buttonClick(ignore: View?) {
        service.sendEmails(inputTextValue.get(), seekBarValue.get(), this)
        Log.d(TAG, "Button Clicked!")
    }

    override fun onSuccess() {
        Log.d(TAG, "Success")
    }

    override fun onFailure() {
        Log.d(TAG, "Failed")
        errorTextVisible.set(true)
        errorTextValue.set("Failed to Send - Need > 50 Emails!")
    }


    companion object {
        const val TAG = "MainViewLogic"
    }
}



/**
 * Wraps [ObservableField.addOnPropertyChangedCallback] with a cleaner interface.
 *
 * Why? For whatever reason, [Observable.OnPropertyChangedCallback] is an abstract class instead of an interface,
 * meaning you can't make use of lambda notation for [ObservableField.addOnPropertyChangedCallback]. This extension just
 * implements it and exposes a lambda function so that you can.
 */
fun <T> ObservableField<T>.onChanged(callback: (T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            callback.invoke(get())
        }
    })
}