package com.example.training

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.training.databinding.ActivityAutarizationRegBinding

class autarization_reg : AppCompatActivity() {
    private lateinit var binding: ActivityAutarizationRegBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutarizationRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            val intent = Intent(this, code_email::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, films_iz::class.java)
            startActivity(intent)
        }
    }
}