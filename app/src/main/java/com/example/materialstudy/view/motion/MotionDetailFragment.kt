package com.example.materialstudy.view.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.materialstudy.R
import com.example.materialstudy.databinding.FragmentMotionDetailBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform

class MotionDetailFragment : Fragment() {

    private lateinit var binding: FragmentMotionDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_motion_detail, container, false)

        setMaterialTransform()

        return binding.root
    }

    private fun setMaterialTransform() {
        MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 500
        }.let {
            sharedElementReturnTransition = it
        }

        exitTransition = Hold()
    }

    companion object {
        fun newInstance() = MotionDetailFragment()
    }
}