package com.laecio.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laecio.convidados.model.GuestModel
import com.laecio.convidados.repository.GuestRepository

class AbsentsViewModel(application: Application) : AndroidViewModel(application) {

   private val repository = GuestRepository.getInstance(application.applicationContext)
    private val _absentsGuests = MutableLiveData<List<GuestModel>>()

    val absentsGuests = _absentsGuests

    fun getAllAbsents() {
        _absentsGuests.value = repository.getAllAbsents()
    }
}