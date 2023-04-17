package dev.ronnie.imageloaderdagger2.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.databinding.FragmentWelcomeBinding


class FragmentWelcome : DaggerFragment(R.layout.fragment_welcome) {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.to_action_fragment_welcome_to_fragment_login)
            Log.i("Click", "Fragment_Welcom_to_Fragment_Login")
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
