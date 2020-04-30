package com.example.materialstudy.view.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.materialstudy.R
import com.example.materialstudy.databinding.FragmentMotionDetailBinding
import com.example.materialstudy.databinding.FragmentMotionHomeBinding
import com.google.android.material.transition.MaterialContainerTransform

class MotionHomeFragment : Fragment() {

    private lateinit var binding: FragmentMotionHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_motion_home, container, false)

        setMaterialTransform()

        return binding.root
    }

    private fun setMaterialTransform() {
        MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_THROUGH
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 500
        }.let {
            sharedElementReturnTransition = it
        }
    }

    companion object {
        fun newInstance() = MotionHomeFragment()
    }
}