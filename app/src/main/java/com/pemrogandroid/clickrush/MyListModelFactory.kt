package com.pemrogandroid.clickrush

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyListModelFactory(private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {

    //generic
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        //type casting
//
//    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyListViewModel(sharedPreferences) as T
    }
}
