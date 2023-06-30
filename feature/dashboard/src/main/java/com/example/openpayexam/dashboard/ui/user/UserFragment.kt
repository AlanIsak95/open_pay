package com.example.openpayexam.dashboard.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openpayexam.dashboard.R
import com.example.openpayexam.dashboard.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    /* */
    private lateinit var binding : FragmentUserBinding

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root

    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}