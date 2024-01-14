package com.example.training.Api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.training.Model.Films
import com.example.training.R
import com.example.training.databinding.FilmsModelImBinding
import com.example.training.films_iz

class AdapterFilms(private val listener: films_iz):  RecyclerView.Adapter<AdapterFilms.FilmsHolder>() {

    private val FilmList = ArrayList<Films>()

    class FilmsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding =  FilmsModelImBinding.bind(item)
        fun bind(result: Films, listener: Listener) = with(binding)
        {
            nameFilm.text = result.title
            reiting.text = result.ratingKinopoisk.toString()

            spisok.setOnClickListener()
            {
                listener.OnClick(result)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilms.FilmsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.films_model_im,parent,false)
        return FilmsHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterFilms.FilmsHolder, position: Int) {
        holder.bind(FilmList[position],listener)
    }

    override fun getItemCount(): Int {
        return FilmList.size
    }

    interface Listener {
        fun OnClick(result: Films)
    }
    fun addResult(item: Films)
    {
        FilmList.add(item)
        notifyDataSetChanged()
    }
}