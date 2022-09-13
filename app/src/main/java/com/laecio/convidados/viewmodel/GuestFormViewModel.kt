package com.laecio.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.laecio.convidados.model.GuestModel
import com.laecio.convidados.repository.GuestRepository


class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val  repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel) {
        repository.insert(guest)
    }
}