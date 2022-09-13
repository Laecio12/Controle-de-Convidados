package com.laecio.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.laecio.convidados.databinding.FragmentsAbsentsBinding
import com.laecio.convidados.view.adapter.GuestsAdapter
import com.laecio.convidados.viewmodel.AbsentsViewModel

class AbsentsFragment : Fragment() {

    private var _binding: FragmentsAbsentsBinding? = null
    private lateinit var viewModel: AbsentsViewModel
    private val adapter = GuestsAdapter()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AbsentsViewModel::class.java]

        _binding = FragmentsAbsentsBinding.inflate(inflater, container, false)

        binding.recyclerAbsentsGuests.layoutManager = LinearLayoutManager(context)

        binding.recyclerAbsentsGuests.adapter = adapter

        viewModel.getAllAbsents()

        observe()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe () {
        viewModel.absentsGuests.observe(viewLifecycleOwner, adapter::updateGuests)
    }
}