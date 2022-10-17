package com.catatankecilku.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.catatankecilku.MainActivity
import com.catatankecilku.databinding.ListDetailActivityBinding
import com.catatankecilku.model.TaskList

class ListDetailActivity:AppCompatActivity() {

    lateinit var list:TaskList

    lateinit var binding: ListDetailActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get parcelable item dari caller activity
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!

        //ubah title dengan name dari detail list
        title = list.name
    }

    //meng overide method saat tombol back
    override fun onBackPressed() {
        val intent= Intent()
        setResult(Activity.RESULT_OK, intent)
        super.onBackPressed()

    }
}