package com.connectedlab.kata4

import android.os.Handler

/**
 * You're not supposed to look at this class.
 *
 * It fakes sending out a network call.
 */
class EmailService {
    fun sendEmails(email: String?, numEmails: Int, callback: Callback?) {
        val handler = Handler()
        handler.postDelayed({
            if (numEmails < 50) {
                callback?.onFailure()
            } else {
                callback?.onSuccess()
            }
        }, 1000)
    }

    interface Callback {
        fun onSuccess()
        fun onFailure()
    }
}