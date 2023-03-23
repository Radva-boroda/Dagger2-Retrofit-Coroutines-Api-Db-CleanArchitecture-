package dev.ronnie.imageloaderdagger2.presentation.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R




class WelcomeFragment : DaggerFragment(R.layout.fragment_welcome) {

    var loginbutton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginbutton = view.findViewById<Button>(R.id.btn_login) as Button
       loginbutton!!.setOnClickListener {
               view: View ->
            view.findNavController().navigate(R.id.to_action_fragment_welcome_to_fragment_login)
           Log.i("Clic","Fragment_Welcom_to_Fragment_Login")
        }
    }
    }
