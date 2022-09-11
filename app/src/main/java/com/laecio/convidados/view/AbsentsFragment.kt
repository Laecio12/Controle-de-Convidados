package com.laecio.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.laecio.convidados.databinding.FragmentsAbsentsBinding
import com.laecio.convidados.viewmodel.AbsentsViewModel

class AbsentsFragment : Fragment() {

    private var _binding: FragmentsAbsentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val absentsViewModel =
            ViewModelProvider(this).get(AbsentsViewModel::class.java)

        _binding = FragmentsAbsentsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}