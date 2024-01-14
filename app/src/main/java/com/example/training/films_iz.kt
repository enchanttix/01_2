package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.training.Api.AdapterFilms
import com.example.training.Api.MyApi
import com.example.training.Model.Films
import com.example.training.databinding.ActivityFilmsIzBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class films_iz : AppCompatActivity(), AdapterFilms.Listener {
    private lateinit var binding: ActivityFilmsIzBinding
    private val TAG = "MainActivity"
    private val adapterFilms = AdapterFilms(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmsIzBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFilms()
    }

    private fun getDataFilms() {
        val api = Retrofit.Builder()
            .baseUrl("https://iis.ngknn.ru/NGKNN/%D0%9C%D0%B0%D0%BC%D1%88%D0%B5%D0%B2%D0%B0%D0%AE%D0%A1/exam/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getsMovie().awaitResponse()
                if (response.isSuccessful) {
                    val data = response.body()!!
                    runOnUiThread {
                        with(binding) {
                            film.layoutManager = LinearLayoutManager(this@films_iz,LinearLayoutManager.HORIZONTAL, false)
                            film.adapter = adapterFilms
                            val listNews: List<Films> = data
                            if (listNews.isNotEmpty()) {
                                for (element in listNews) {
                                    adapterFilms.addResult(element)
                                }
                            }
                        }}
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d(TAG, e.toString())
                }
            }
        }
    }

    override fun OnClick(result: Films) {
        TODO("Not yet implemented")
    }
}