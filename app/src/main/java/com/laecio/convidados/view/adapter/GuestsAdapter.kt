package com.laecio.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laecio.convidados.databinding.RowGuestBinding
import com.laecio.convidados.model.GuestModel
import com.laecio.convidados.view.viewHolder.GuestsViewHolder

class GuestsAdapter: RecyclerView.Adapter<GuestsViewHolder>() {
    private var guestList : List<GuestModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestsViewHolder {
        val itemView = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GuestsViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updateGuests (list: List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }
}