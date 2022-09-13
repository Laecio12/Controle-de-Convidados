package com.laecio.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.laecio.convidados.R
import com.laecio.convidados.databinding.ActivityGuestFormBinding
import com.laecio.convidados.model.GuestModel
import com.laecio.convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]

        binding.btnSave.setOnClickListener(this)
        true.also { binding.radioBtnPresent.isChecked = it }
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btnSave) {
            val name = binding.editTextName.text.toString()
            val presence = binding.radioBtnPresent.isChecked
            val guest = GuestModel(0,  name,  presence)
            viewModel.insert(guest)
        }
    }
}