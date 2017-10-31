package com.connectedlab.kata4

import android.databinding.Observable
import android.databinding.ObservableField
import android.util.Log
import android.view.View

class MainViewLogic(val service: SignupService) : SignupService.Callback {

    companion object {
        const val TAG = "MainViewLogic"
    }

    val inputTextValue = ObservableField("")
    val errorTextVisible = ObservableField(false)

    init {
        inputTextValue.onChanged {
            Log.d(TAG, "Input Text: ${inputTextValue.get()}")
        }
    }

    fun buttonClick(ignore: View) {
        Log.d(TAG, "Button Clicked!")
    }

    override fun onSuccess() {
        Log.d(TAG, "Success")
    }

    override fun onFailure() {
        Log.d(TAG, "Failed")
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