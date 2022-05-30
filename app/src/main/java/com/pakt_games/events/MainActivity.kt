package com.pakt_games.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pakt_games.events.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        bindingMain.buttonTest.setOnClickListener {
            println("SetONClickListener Tıklandı")
        }

        bindingMain.buttonTest.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                println("LONG CLİCK Tıklandı")
                return true  }
        })

        bindingMain.buttonTest.setOnFocusChangeListener { view, b -> println("On focus change listener tetiklendi") }


    }
}