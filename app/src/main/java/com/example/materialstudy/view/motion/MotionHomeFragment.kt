package com.example.materialstudy.view.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.transition.Fade
import androidx.transition.TransitionManager
import com.example.materialstudy.R
import com.example.materialstudy.databinding.FragmentMotionHomeBinding
import com.example.materialstudy.util.InjectorUtils
import com.example.materialstudy.viewmodel.BottomNavViewModel
import com.example.materialstudy.viewmodel.MotionViewModel
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFade

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
        setFloatingActionButton(container!!)
        subscribeUi()

        exitTransition = Hold()

        return binding.root
    }

    private fun setMaterialTransform(): MaterialContainerTransform {

        return MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
            fitMode = MaterialContainerTransform.FIT_MODE_AUTO
            duration = 500
        }
    }

    private fun setFloatingActionButton(container: ViewGroup) {
        binding.floatingActionButton.setOnClickListener {
            // MaterialFade를 사용하고 싶으나 호환이 안되어 기본 Fade 옵션 적용
//            val materialFade = MaterialFade.create()
            val mFade = Fade(Fade.OUT);

            TransitionManager.beginDelayedTransition(container, mFade)

            it.visibility = View.INVISIBLE
        }
    }

    private fun subscribeUi() {
        viewModel.showDetailPage.observe(viewLifecycleOwner, Observer {

            if (it) {

                (activity as MotionActivity).changeFragment(
                    binding.card,
                    binding.card.transitionName!!,
                    MotionDetailFragment.newInstance().apply {
                        sharedElementEnterTransition = setMaterialTransform()
                    }
                )

                viewModel.showDetailPage.value = false
            }
        })
    }

    companion object {
        fun newInstance() = MotionHomeFragment()
    }
}