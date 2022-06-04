package com.pakt_games.events

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ContextMenu
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pakt_games.events.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityMainBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        registerForContextMenu(bindingMain.buttonMenuOpener)

        onClickEvent()
        onLongClickEvent()
        setOnKeyListenerEvent()
        setOnFocusListenerEvent()
        setOnTouchListenerEvent()

        bindingMain.editTextTest.requestFocus()

        bindingMain.editTextTest.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                println(s.toString() + "     onTextChanged")
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                println(s.toString() + "    beforeTextChanged")
            }
            override fun afterTextChanged(s: Editable) {
                println(s.toString() + "     afterTextChanged")
            }
        })

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        println("dispatchTouchEvent çalıştı")
        return super.dispatchTouchEvent(event)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_example, menu)
    }


    fun onClickEvent() {
        bindingMain.buttonTest.setOnClickListener {
            println("SetONClickListener Tıklandı")
        }
    }
    fun onLongClickEvent() {
        bindingMain.buttonTest.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                println("LONG CLİCK Tıklandı")
                return true  }
        })
    }
    fun setOnKeyListenerEvent() {
        bindingMain.buttonTest.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                return if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    println("onKey için Entera tıklanıldı.")
                    true
                } else false
            }
        })
    }
    fun setOnFocusListenerEvent() {
        bindingMain.editTextTest.setOnFocusChangeListener { _, b -> println("On focus change listener tetiklendi") }
    }
    @SuppressLint("ClickableViewAccessibility")
    fun setOnTouchListenerEvent() {
        bindingMain.buttonTest.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){
                MotionEvent.ACTION_DOWN -> {
                    println(" setOnTouchListener Buttona basmaya başladınız")
                }
                MotionEvent.ACTION_UP -> {
                    println(" setOnTouchListener Buttona basmayı bıraktınız")
                }
            }
            return@OnTouchListener true
        })

    }
}