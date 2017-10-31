package com.connectedlab.kata4

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.connectedlab.kata4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var service: EmailService
    private lateinit var toastMaker: ToastMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        service = EmailService()
        toastMaker = ToastMaker(this)


        binding.viewLogic = MainViewLogic(service, toastMaker)
    }
}
