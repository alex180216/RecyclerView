package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    var lista: RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platillos = ArrayList<Platillo>()
        platillos.add(Platillo("Plato 1", 250.0, 4.0, R.drawable.plato01))
        platillos.add(Platillo("Plato 2", 150.0, 3.0, R.drawable.plato02))
        platillos.add(Platillo("Plato 3", 100.0, 1.0, R.drawable.plato03))
        platillos.add(Platillo("Plato 4", 1000.0, 5.0, R.drawable.plato04))
        platillos.add(Platillo("Plato 5", 355.0, 2.0, R.drawable.plato05))
        platillos.add(Platillo("Plato 6", 120.0, 4.0, R.drawable.plato06))
        platillos.add(Platillo("Plato 7", 280.0, 3.0,R.drawable.plato07))

        lista = findViewById(R.id.recycler_lista)
        lista?.setHasFixedSize(true)//si tiene un tamaño fijo...

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager //le decimos desde donde quiero que se dibuje nuestro layout

        adaptador = AdaptadorCustom( platillos, object:ClickListener{
            override fun OnClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, platillos.get(index).nombre, Toast.LENGTH_SHORT).show()
            }

        })
        lista?.adapter = adaptador

        //REFRESH DE MAIN ACTIVITY
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        swipeRefreshLayout.setOnRefreshListener {
            for(i in 1..1000000){
                //para verificar que funciona la carga durante el swipe
            }
            swipeRefreshLayout.isRefreshing = false
            platillos.add(Platillo("Nuggets", 10.0, 4.7, R.drawable.plato05))
            adaptador?.notifyDataSetChanged()
        }
    }


}
