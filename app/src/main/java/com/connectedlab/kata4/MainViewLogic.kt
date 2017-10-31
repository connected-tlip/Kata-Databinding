package com.connectedlab.kata4

import android.databinding.Observable
import android.databinding.ObservableField
import android.util.Log
import android.view.View

class MainViewLogic(val service: EmailService,
                    val toastMaker: ToastMaker) : EmailService.Callback {

    companion object {
        const val TAG = "MainViewLogic"
    }

    val inputTextValue = ObservableField("")
    val errorTextVisible = ObservableField(false)
    val seekbarProgress = ObservableField(0)
    val numEmailsValue = ObservableField("")
    val errorTextValue = ObservableField("")

    init {
        inputTextValue.onChanged { newValue ->
            Log.d(TAG, "Input Text: $newValue")
            errorTextVisible.set(!newValue.contains("@"))
            errorTextValue.set("Invalid Email Address")
        }

        seekbarProgress.onChanged { newValue ->
            numEmailsValue.set("Number of emails: $newValue")
        }
    }

    fun buttonClick(ignore: View?) {
        Log.d(TAG, "Button Clicked!")
        service.sendEmails(inputTextValue.get(), seekbarProgress.get(), this)
    }

    override fun onSuccess() {
        Log.d(TAG, "Success")
        toastMaker.makeToast("Success!")
    }

    override fun onFailure() {
        Log.d(TAG, "Failed")
        errorTextVisible.set(true)
        errorTextValue.set("Failed to Send - Need > 50 Emails!")
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