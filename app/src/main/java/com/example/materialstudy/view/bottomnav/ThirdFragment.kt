package com.example.materialstudy.view.bottomnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import com.example.materialstudy.R
import com.example.materialstudy.databinding.FragmentThirdBinding
import com.example.materialstudy.util.InjectorUtils
import com.example.materialstudy.viewmodel.BottomNavViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val testViewModel: BottomNavViewModel by activityViewModels()

    private lateinit var binding: FragmentThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)

        setupUi(binding)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setupUi(binding: FragmentThirdBinding) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = testViewModel
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
