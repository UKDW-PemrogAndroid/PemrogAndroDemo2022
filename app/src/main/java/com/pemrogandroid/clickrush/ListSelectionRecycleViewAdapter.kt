package com.pemrogandroid.clickrush

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pemrogandroid.clickrush.databinding.ListSelectionViewHolderBinding

class ListSelectionRecycleViewAdapter(private val lists : MutableList<MahasiswaList>) :
    RecyclerView.Adapter<ListSelectionViewHolder>() {

//    val listExample = arrayOf("dendy", "frans", "jesslyn", "andreas", "Ryan", "Deon", "Kenny")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        //apa yg aka dilakukan saat viewholder dibuat obyeknya
        val binding = ListSelectionViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ListSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        //utk mengetahui jumlah item yang ada pada recycle view
        return lists.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        //melakukan mekanisme binding data dengan view holder
        holder.binding.txtId.text =  (position + 1).toString()
        holder.binding.txtName.text = lists[position].name
    }

    fun listsUpdate() {
        notifyItemInserted(lists.size-1)
    }

}
