package com.example.ladm_u2_tarea2

import android.os.CountDownTimer

class HiloCargando(act: MainActivity) : Thread() {
    var index=0
    val arregloConsejos = arrayOf("Puedes moverte sigilosamente si precionas B, los enemigos no te detectarán",
        "Si te quedas mucho tiempo parado, tu personaje puede morir","Si no comes lo suficiente perderas vida poco a poco",
        "Ten cuidado al caer, puede que le lastimes o mueras")

    val act = act
    var contador=0
    val timer = object : CountDownTimer(30000,200){
        override fun onTick(p0: Long) {
            act.runOnUiThread {
                if(contador<=100)
                act.binding.tvCargado.setText("Cargando ${contador++}%")
                else act.binding.tvCargado.setText("PRESIONA ENTER PARA CONTINUAR")

            }
        }
        override fun onFinish() {
        }
    }

        override fun run() {
            super.run()
            timer.start() //Simula que obtiene el porcentaje de carga
            sleep(10000) //Simula que carga el mapa

            act.runOnUiThread {
                act.binding.button.setOnClickListener {
                    if(index==arregloConsejos.size-1)
                        index=0
                    act.binding.textView.text=arregloConsejos[index]
                    index++
                }
            }
        }



/*
    fun cargar1(){
        act.runOnUiThread {
        act.binding.textView.text="Presiona el Boton para ver Consejos"
        }
    }
    fun cargar2(){
        act.runOnUiThread {
            act.binding.tvCargado.text="Juego Cargado 100%"
        }
    }
    */





    }
