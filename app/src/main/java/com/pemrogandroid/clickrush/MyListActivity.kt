package com.pemrogandroid.clickrush

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pemrogandroid.clickrush.databinding.ActivityMyListBinding

class MyListActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMyListBinding

    private lateinit var viewModel: MyListViewModel
//    private val sharedpreferanceFile ="mySharedPref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            MyListModelFactory(androidx.preference.PreferenceManager.getDefaultSharedPreferences(this))
        ).get(MyListViewModel::class.java)

        val adapter = ListSelectionRecycleViewAdapter(viewModel.lists)

        //pemanggilan method callback view model
        viewModel.onListAdded = {
            adapter.listsUpdate()
        }

        binding.listsRecycleview.layoutManager = LinearLayoutManager(this)
        binding.listsRecycleview.adapter = adapter
        binding.tambah.setOnClickListener({
            viewModel.saveList(MahasiswaList("dendy"))
        })

//        val sharedPreferences:SharedPreferences = this.getSharedPreferences(sharedpreferanceFile,
//            Context.MODE_PRIVATE)
//        val editor:SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putInt("nim",1)
//        editor.putString("nama", "dendy")
//        editor.apply()
//        println("Nim "+sharedPreferences.getInt("nim",0))
//        println("Nama "+sharedPreferences.getString("nama","default"))
    }
}