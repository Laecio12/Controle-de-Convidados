package com.laecio.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.laecio.convidados.databinding.FragmentPresentsBinding
import com.laecio.convidados.view.adapter.GuestsAdapter
import com.laecio.convidados.viewmodel.PresentsViewModel

class PresentsFragment : Fragment() {

    private var _binding: FragmentPresentsBinding? = null
    private  lateinit var viewModel: PresentsViewModel
    private val adapter = GuestsAdapter()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[PresentsViewModel::class.java]

        _binding = FragmentPresentsBinding.inflate(inflater, container, false)

        binding.recyclerPresentsGuests.layoutManager = LinearLayoutManager(context)

        binding.recyclerPresentsGuests.adapter =  adapter

        viewModel.getAllPresents()

        observe()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe () {
       viewModel.presentsGuests.observe(viewLifecycleOwner, adapter::updateGuests)
    }
}