package com.example.recyclerview

import android.widget.ImageView

class Platillo(nombre:String, precio:Double, calificacion:Double, foto:Int) {
    var nombre = ""
    var precio = 0.0
    var calificacion = 0.0
    var foto = 0

    init {
        this.nombre = nombre
        this.calificacion = calificacion
        this.precio = precio
        this.foto = foto
    }

}