package com.example.aeon.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.aeon.databinding.FragmentLoginBinding
import com.example.aeon.plugins.ViewBindingFragment
import com.example.aeon.vm.login.LoginViewModel
import com.google.android.material.snackbar.Snackbar

class LoginFragment : ViewBindingFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel = LoginViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()



        binding.login.isEnabled = false

        binding.username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.password.text.isNotEmpty()) binding.login.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {
                if (binding.username.text.isEmpty()||binding.password.text.isEmpty()) binding.login.isEnabled = false
            }
        })

        binding.password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.username.text.isNotEmpty()) binding.login.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {
                if (binding.username.text.isEmpty()||binding.password.text.isEmpty()) binding.login.isEnabled = false
            }
        })

        binding.login.setOnClickListener {
            viewModel.logon(login = binding.username.text.toString(),
                password =  binding.password.text.toString()
            )
        }
    }

    private fun bindViewModel() {

        viewModel.loading.observe(viewLifecycleOwner, ::updateLoadingState)
        viewModel.error.observe(viewLifecycleOwner, ::showMessage)
        viewModel.token.observe(viewLifecycleOwner, ::showPaysList)
    }

    private fun updateLoadingState(isLoading: Boolean) {
        binding.loginVigetGroup.isVisible = isLoading.not()
        binding.loading.isVisible = isLoading
    }

    private fun showMessage(text: String) {
        Log.e("showMessage", "ERROR: $text")
        Snackbar.make(requireView(), "ERROR: $text", Snackbar.LENGTH_LONG).show()
    }

    private fun showPaysList(token: String) {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToPaysFragment(token))
    }



}
