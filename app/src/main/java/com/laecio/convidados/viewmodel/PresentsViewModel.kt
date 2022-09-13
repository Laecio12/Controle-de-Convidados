package com.laecio.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.laecio.convidados.model.GuestModel
import com.laecio.convidados.repository.GuestRepository

class PresentsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application.applicationContext)

    private val _presentsGuests  = MutableLiveData<List<GuestModel>>()

    val presentsGuests: MutableLiveData<List<GuestModel>> = _presentsGuests

    fun getAllPresents() {
        _presentsGuests.value = repository.getAllPresents()
    }

}