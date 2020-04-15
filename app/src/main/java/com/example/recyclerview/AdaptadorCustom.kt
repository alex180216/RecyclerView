package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.template_comidas.view.*
import org.w3c.dom.Text

class AdaptadorCustom(var contexto: Context, items: ArrayList<Platillo>): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    var items:ArrayList<Platillo>? = null
    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.template_comidas, parent, false)
        val viewHolder = ViewHolder(vista)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    //MAPEO DE ELEMENTOS
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombre?.text = item?.nombre
        holder.precio?.text = item?.precio.toString()
        holder.rating?.rating = item?.calificacion?.toFloat()!!
    }

    //CREAMOS LA CLASE VIEW HOLDER
    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        var vista = vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var precio:TextView? = null
        var rating:RatingBar? = null

        init {
            foto = vista.findViewById(R.id.iv_comida)
            nombre = vista.findViewById(R.id.tv_nombre_plato)
            precio = vista.findViewById(R.id.tv_precio_plato)
            rating = vista.findViewById(R.id.rating_bar)
        }
    }

}