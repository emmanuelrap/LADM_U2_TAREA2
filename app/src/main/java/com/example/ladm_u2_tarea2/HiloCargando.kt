package com.example.ladm_u2_tarea2

import android.os.CountDownTimer
import kotlinx.coroutines.delay
import kotlin.random.Random

class HiloCargando(act: MainActivity) : Thread() {
    var index=0
    var arregloImagenes = arrayOf(R.drawable.fondo1,R.drawable.fondo2,R.drawable.fondo3,R.drawable.fondo4,R.drawable.fondo5,
        R.drawable.fondo7,R.drawable.fondo8,R.drawable.fondo9,R.drawable.fondo10,R.drawable.fondo11,R.drawable.fondo12,R.drawable.fondo13)
    val arregloConsejos = arrayOf("Puedes moverte sigilosamente si precionas B, los enemigos no te detectarán",
        "Si te quedas mucho tiempo parado, tu personaje puede morir","Si no comes lo suficiente perderas vida poco a poco",
        "Ten cuidado al caer, puede que le lastimes o mueras")

    val act = act
    var contador=0
    val timer = object : CountDownTimer(30000,100){
        override fun onTick(p0: Long) {
            act.runOnUiThread {
                if(contador<=100)
                act.binding.tvCargado.setText("Cargando ${contador++}%")
                else{
                }
            }
        }
        override fun onFinish() {
        }
    }

        override fun run() {
            super.run()
            timer.start() //Simula que obtiene el porcentaje de carga
            cargarMapa() //Simula que carga el mapa

            act.runOnUiThread { //ya que carga el mapa muestra el aviso de continuar
                act.binding.tvCargado.setText("> PRESIONA ENTER PARA CONTINUAR <")
            }

           cambiarImagen()


            act.runOnUiThread {
                act.binding.button.setOnClickListener {
                    if(index==arregloConsejos.size-1)
                        index=0
                    act.binding.textView.text=arregloConsejos[index]
                    index++
                }
            }
        }


    fun cargarMapa(){
        sleep(20000)
        return
    }

    fun cambiarImagen(){
        while(true) {
            act.runOnUiThread {
                act.binding.imageView2.setImageResource(arregloImagenes[Random.nextInt(12)])
                sleep(5000)
            }
        }
    }





    }
