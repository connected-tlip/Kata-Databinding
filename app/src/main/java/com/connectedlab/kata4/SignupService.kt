package com.connectedlab.kata4

import android.os.Handler


class SignupService {
    fun signup(email: String, numEmails: Int, callback: Callback) {
        val handler = Handler()
        handler.postDelayed({
            if (numEmails < 50) {
                callback.onFailure()
            } else {
                callback.onSuccess()
            }
        }, 1000)
    }

    interface Callback {
        fun onSuccess()
        fun onFailure()
    }
}