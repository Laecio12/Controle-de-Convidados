package com.laecio.convidados.view.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.laecio.convidados.databinding.RowGuestBinding
import com.laecio.convidados.model.GuestModel

class GuestsViewHolder(private val binding: RowGuestBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind (guest: GuestModel) {
        binding.txtName.text = guest.name
        binding.txtPresence.text = guest.presence.toString()
    }

}