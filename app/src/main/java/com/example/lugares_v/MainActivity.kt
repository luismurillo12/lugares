package com.example.lugares_v

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lugares_v.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
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
        FirebaseApp.initializeApp(this)
        auth= Firebase.auth
        binding.etEmail
    }
}
