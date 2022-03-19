package com.example.ladm_u2_tarea2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import androidx.core.view.MotionEventCompat
import com.example.ladm_u2_tarea2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var mp: MediaPlayer?=null
    var index=0
    val arregloConsejos = arrayOf("Puedes moverte sigilosamente si precionas B",
        "Si te quedas mucho tiempo parado, tu personaje puede morir","Si no comes lo suficiente perderas vida poco a poco",
        "Ten cuidado al caer, puede que le lastimes o mueras")
    var arregloImagenes = arrayOf(R.drawable.fondo1,R.drawable.fondo2,R.drawable.fondo3,R.drawable.fondo4,R.drawable.fondo5,
        R.drawable.fondo7,R.drawable.fondo8,R.drawable.fondo9,R.drawable.fondo10,R.drawable.fondo11,R.drawable.fondo12,R.drawable.fondo13)
    var contador=0
    val timer = object : CountDownTimer(30000,200){
        override fun onTick(p0: Long) {
                if(contador<=100)
                    binding.tvCargado.setText("Cargando ${contador++}%")
                else{}
        }
        override fun onFinish() {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val hilo = HiloCargando(this)
       // hilo.start()


        GlobalScope.launch(Dispatchers.Main) {
            cargarMapa()
            binding.tvCargado.setText("PRESIONA ENTER PARA CONTINUAR")
        }

        GlobalScope.launch(Dispatchers.Main) {
            binding.textView.setText("Presiona el Boton para ver Consejos")
        }

        GlobalScope.launch(Dispatchers.Main) {
          cambiarImagen()
        }

        GlobalScope.launch(Dispatchers.Main) {
            ponerCancion()
        }

       binding.button.setOnClickListener {
            if(index==arregloConsejos.size-1)
                index=0
            binding.textView.text=arregloConsejos[index]
            index++
        }

    }

    suspend fun cargarMapa(){
        timer.start()
        delay(25000L)
        parpadearTV()
    }
    suspend fun cambiarImagen(){
        while(true) {
                binding.imageView2.setImageResource(arregloImagenes[Random.nextInt(13)])
                delay(5000)
        }
    }

    fun ponerCancion(){
        mp= MediaPlayer.create(this,R.raw.cancionelden)
        mp?.start()
    }

    suspend fun parpadearTV(){
        while (true) {
            binding.tvCargado.setText(">> PRESIONA START PARA CONTINUAR <<")
            delay(2000)
            binding.tvCargado.setText("")
            delay(1000)
        }
    }

}
