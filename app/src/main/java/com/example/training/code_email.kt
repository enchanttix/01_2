package com.example.training

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.training.databinding.ActivityCodeEmailBinding

class code_email : AppCompatActivity() {
    private lateinit var binding: ActivityCodeEmailBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            val intent = Intent(this, autarization_reg::class.java)
            startActivity(intent)
        }

        timerSec(60000)
    }

    fun timerSec(startTimeInMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(startTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var millisUntilFinished = millisUntilFinished / 1000
                binding.timer.text = millisUntilFinished.toString()
            }

            override fun onFinish() {
                binding.timer.text = "0"
            }
        }.start()
    }
}