package com.laecio.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laecio.convidados.model.GuestModel
import com.laecio.convidados.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {
        private val repository = GuestRepository.getInstance(application.applicationContext)

    private val _guests = MutableLiveData<List<GuestModel>>()
    val guests : LiveData<List<GuestModel>> = _guests

    fun getAll(){
        _guests.value = repository.getAll()
    }
}