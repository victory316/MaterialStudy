package com.example.materialstudy.view.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.materialstudy.R
import com.example.materialstudy.databinding.FragmentMotionHomeBinding
import com.example.materialstudy.util.InjectorUtils
import com.example.materialstudy.viewmodel.MotionViewModel
import com.google.android.material.transition.MaterialContainerTransform

class MotionHomeFragment : Fragment() {

    private lateinit var binding: FragmentMotionHomeBinding

    private val viewModel: MotionViewModel by viewModels {
        InjectorUtils.provideMotionViewModel(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_motion_home, container, false)

        binding.apply {
            viewModel = this@MotionHomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        setMaterialTransform()
        subscribeUi()

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

    private fun subscribeUi() {
        viewModel.showDetailPage.observe(viewLifecycleOwner, Observer {

            if (it) {

                (activity as MotionActivity).changeFragment(
                    binding.card,
                    binding.card.transitionName!!,
                    MotionDetailFragment.newInstance()
                )

                viewModel.showDetailPage.value = false
            }
        })
    }

    companion object {
        fun newInstance() = MotionHomeFragment()
    }
}