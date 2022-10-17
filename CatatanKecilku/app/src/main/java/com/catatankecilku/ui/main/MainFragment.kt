package com.catatankecilku.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.catatankecilku.databinding.MainFragmentBinding
import com.catatankecilku.model.TaskList

class MainFragment(val clickListener : MainFragmentInteractionListener) : Fragment(), ListSelectionRecyclerViewAdapter.ListSelectionRecylerViewClickListener {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        //static method untuk create MainFragment
        fun newInstance(clickListener: MainFragmentInteractionListener): MainFragment {
            return MainFragment(clickListener)
        }
    }

    interface MainFragmentInteractionListener{
        fun listItemTapped(list: TaskList)
    }

    //callback yang diekskusi saat fragment sedang dibuat
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.listsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    //callback yg dieksekusi saat fragment sudah dibuat
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                PreferenceManager.getDefaultSharedPreferences(requireActivity())
            )
        )
            .get(MainViewModel::class.java)

        val recyclerViewAdapter = ListSelectionRecyclerViewAdapter(viewModel.lists, this)
        binding.listsRecyclerview.adapter = recyclerViewAdapter

        viewModel.onListAdded = {
            recyclerViewAdapter.listsUpdated()
        }
    }

    override fun listItemClicked(list : TaskList) {
        clickListener.listItemTapped(list)
    }
}