package com.example.aeon.ui.pays.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.aeon.data.Pays
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class PayListAdapter : AsyncListDifferDelegationAdapter<Pays>(PaysDiffUtilCallBack()) {

    init {
        delegatesManager.addDelegate(PaysDelegateAdapter())
    }

    class PaysDiffUtilCallBack : DiffUtil.ItemCallback<Pays>() {
        override fun areItemsTheSame(oldItem: Pays, newItem: Pays): Boolean {
            return oldItem.desc == newItem.desc
        }

        override fun areContentsTheSame(oldItem: Pays, newItem: Pays): Boolean {
            return oldItem == newItem
        }
    }
}
