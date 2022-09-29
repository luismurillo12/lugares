package com.example.lugares_v

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lugares_v.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    //Definicion del objeto para la autenticacion

    private lateinit var auth: FirebaseAuth
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //se inicializa firebase para usarse en el app
        //Se asigna el objeto
        FirebaseApp.initializeApp(this)
        auth= Firebase.auth

        binding.btRegistro.setOnClickListener{ haceRegistro()}
        binding.btLogin.setOnClickListener{ haceLogin()}



    }

    private fun haceRegistro(){
        //Recuperamos la informacion que ingresa el usuario
       val email = binding.etEmail.text.toString()
       val clave = binding.etClave.text.toString()
        //se llama a la funcion para crear un ususario en firebase

        auth.createUserWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this){task->
                var user: FirebaseUser? =null
                if(task.isSuccessful){//si pudo crear el usuario
                    Log.d("Auntenticando","Usuario creado")
                    user= auth.currentUser // recupero la info del usuario creado
                }else{
                    Log.d("Auntenticado", "Error creando el usuario")
                }
                actualiza(user)
            }
    }

    private fun haceLogin(){
        //Recuperamos la informacion que ingresa el usuario
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()
        //se llama a la funcion para crear un ususario en firebase

        auth.signInWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this){task->
                var user: FirebaseUser? =null
                if(task.isSuccessful){//si pudo crear el usuario
                    Log.d("Auntenticando","Usuario creado")
                    user= auth.currentUser // recupero la info del usuario creado
                }else{
                    Log.d("Auntenticado", "Error aunteticando el usuario")
                }
               actualiza(user)
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        //si hay un usuario definido se pasa a la pantalla principal
        if(user!=null){
            //Se pasa de pantalla
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }
   public  fun onSrart(){
       super.onStart()
       val ususario= auth.currentUser
       actualiza(ususario)
   }
}
