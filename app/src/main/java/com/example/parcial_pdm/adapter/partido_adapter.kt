package com.example.parcial_pdm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_pdm.entities.partido
import com.example.parcial_pdm.R
import kotlinx.android.synthetic.main.recycleritem.view.*

class partido_adapter(var partido : List<partido>, var clickListener: (partido) -> Unit) : RecyclerView.Adapter<partido_adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): partido_adapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycleritem, parent, false))
    }

    override fun getItemCount(): Int = partido.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(partido[position], clickListener)

    internal fun setPartido(partido: List<partido>){
        this.partido = partido
        notifyDataSetChanged()
    }

    class ViewHolder(var item : View) : RecyclerView.ViewHolder(item){
        fun onBind(partido: partido, clickListener: (partido) -> Unit){
            itemView.tv_partido.text = "Partido: " + partido.equipo1 + " vs " + partido.equipo2
            itemView.tv_fecha.text = "Fecha: " + partido.fecha
            itemView.tv_hora.text = "Hora: " + partido.hora

            this.item.setOnClickListener{
                clickListener(partido)
            }
        }
    }
}