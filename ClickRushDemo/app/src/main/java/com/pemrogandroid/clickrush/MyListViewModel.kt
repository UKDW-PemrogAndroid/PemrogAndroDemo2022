package com.pemrogandroid.clickrush

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel

class MyListViewModel(private val sharedPreferences: SharedPreferences): ViewModel() {

    //method callback
    lateinit var onListAdded: (()->Unit)

    val lists: MutableList<MahasiswaList> by lazy {
        retriveLists()
    }

    private fun retriveLists() : MutableList<MahasiswaList>{
        val sharedPreferencesContents = sharedPreferences.all

        //array temporary
        val mhsLists = ArrayList<MahasiswaList>()

        //ambli smua record mhs dari shared preference dan dibuffer ke array list mhs
        for (mhsList in sharedPreferencesContents){
            val itemHashSet = ArrayList(mhsList.value as HashSet<String>)
            val list = MahasiswaList(mhsList.key, itemHashSet)
            mhsLists.add(list)
        }

        //di returnkan
        return mhsLists
    }

    fun saveList(list : MahasiswaList){
        sharedPreferences.edit().putStringSet(list.name, list.tasks.toHashSet()).apply()
        lists.add(list)
        onListAdded.invoke()
    }
}