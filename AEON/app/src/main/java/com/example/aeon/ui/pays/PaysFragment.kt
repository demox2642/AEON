package com.example.aeon.ui.pays

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aeon.R
import com.example.aeon.databinding.FragmentPaysBinding
import com.example.aeon.plugins.ViewBindingFragment
import com.example.aeon.ui.pays.adapter.PayListAdapter
import com.example.aeon.vm.login.LoginViewModel

class PaysFragment : ViewBindingFragment<FragmentPaysBinding>(FragmentPaysBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()
    private var paysAdapter: PayListAdapter? = null
    private val args by navArgs<PaysFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.paysList(args.token)
        bindViewModel()
        initList()
        binding.buttonLogOff.setOnClickListener {
            findNavController().navigate(R.id.action_paysFragment_to_loginFragment2)
        }
    }

    private fun bindViewModel() {

        viewModel.loading.observe(viewLifecycleOwner, ::updateLoadingState)
        viewModel.pays.observe(viewLifecycleOwner) { paysAdapter?.items = it }
    }

    private fun initList() {
        paysAdapter = PayListAdapter()
        with(binding.paysRecycle) {
            adapter = paysAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun updateLoadingState(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
        binding.paysRecycle.isVisible = isLoading.not()
        binding.buttonLogOff.isVisible = isLoading.not()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
