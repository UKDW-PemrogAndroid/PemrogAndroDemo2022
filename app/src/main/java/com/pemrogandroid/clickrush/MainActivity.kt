package com.pemrogandroid.clickrush

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var button: Button
    lateinit var text: TextView
    var textDummy: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_constraint)
        Log.d(TAG, "onCreate: execute")
        button = findViewById(R.id.button)
        text = findViewById(R.id.TextViewConstLayout)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Log.d(TAG, "onClick: execute")
                textDummy = "onClick: execute"
                text.text = textDummy
                Toast.makeText(applicationContext, "Text has been changed", Toast.LENGTH_LONG).show()

                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_example)
                text.startAnimation(animation)
            }
        })

        if (savedInstanceState != null) {
            textDummy = savedInstanceState.getString("DUMMY_TEXT").toString()
            text.text = textDummy
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_dummy){
            Toast.makeText(applicationContext, "Menu item selected", Toast.LENGTH_LONG).show()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("DUMMY_TEXT", textDummy)

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: execute")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: execute")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: execute")
    }
}