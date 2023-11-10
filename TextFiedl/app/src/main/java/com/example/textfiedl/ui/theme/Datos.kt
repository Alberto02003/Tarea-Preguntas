package com.example.textfiedl.ui.theme

import com.example.textfiedl.Preguntas
import com.example.textfiedl.R

class Datos {
    var ArrayLista = datos()
    fun datos(): ArrayList<Preguntas>{
        var estado = ArrayList<Preguntas>()
        var uno = Preguntas(R.string.Uno,R.drawable.cristiano_y_messi,true)
        var dos = Preguntas(R.string.Dos,R.drawable.dos,true)
        var tres = Preguntas(R.string.Tres,R.drawable.tres,true)
        var cuatro = Preguntas(R.string.Cuatro,R.drawable.cuatro,true)
        var cinco = Preguntas(R.string.Cinco,R.drawable.cinco,true)
        estado.add(uno)
        estado.add(dos)
        estado.add(tres)
        estado.add(cuatro)
        estado.add(cinco)
        return estado
    }
}