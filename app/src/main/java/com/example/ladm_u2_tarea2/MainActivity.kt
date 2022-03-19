package com.example.ladm_u2_tarea2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.core.view.MotionEventCompat
import com.example.ladm_u2_tarea2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var index=0
    val arregloConsejos = arrayOf("Puedes moverte sigilosamente si precionas B, los enemigos no te detectarán",
        "Si te quedas mucho tiempo parado, tu personaje puede morir","Si no comes lo suficiente perderas vida poco a poco",
        "Ten cuidado al caer, puede que le lastimes o mueras")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hilo = HiloCargando(this)
        hilo.start()

/*
        GlobalScope.launch(Dispatchers.Main) {
            cargar2()
        }

        GlobalScope.launch(Dispatchers.Main) {
            cargar1()
        }

       /binding.button.setOnClickListener {
            if(index==arregloConsejos.size-1)
                index=0
            binding.textView.text=arregloConsejos[index]
            index++
        }

    }

     fun cargar1(){
        binding.textView.text="Presiona el Boton para ver Consejos"
    }

    suspend fun cargar2(){
        Thread.sleep(10000L)
        binding.tvCargado.text="Juego Cargado 100%"
    }


*/
    }
    }
