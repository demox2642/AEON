package com.example.aeon.ui.pays.adapter

import android.view.View
import android.view.ViewGroup
import com.example.aeon.R
import com.example.aeon.data.Pays
import com.example.aeon.plugins.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class PaysDelegateAdapter : AbsListItemAdapterDelegate<Pays, Pays, PaysDelegateAdapter.PaysViewHolder>() {
    override fun isForViewType(
        item: Pays,
        items: MutableList<Pays>,
        position: Int
    ): Boolean {
        return items[position] is Pays
    }

    override fun onCreateViewHolder(parent: ViewGroup): PaysViewHolder {
        return PaysViewHolder(parent.inflate(R.layout.pays_vie_for_list))
    }

    class PaysViewHolder(view: View) : BaseHolder(view) {

        fun bind(pay: Pays) {
            bindMainInfo(amount = pay.amount, created = pay.created, currency = pay.currency, desc = pay.desc!!)
        }

        override val containerView: View
            get() = itemView
    }

    override fun onBindViewHolder(
        item: Pays,
        holder: PaysViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }
}
