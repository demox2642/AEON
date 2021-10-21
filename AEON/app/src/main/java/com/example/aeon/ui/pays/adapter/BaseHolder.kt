package com.example.aeon.ui.pays.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aeon.data.PayCurrency
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pays_vie_for_list.*
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
    protected fun bindMainInfo(
        amount: Double,
        created: Date?,
        currency: PayCurrency?,
        desc: String
    ) {

        val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")

        amount_text.text = amount.toBigDecimal().toPlainString()
        created_text.text = if (created != null) { formatter.format(created).toString() } else { "" }
        currency_text.text = if (currency == PayCurrency.NOT_INDICATED) {
            ""
        } else {
            currency.toString()
        }
        desc_text.text = desc
        desc_text.setPadding(0,0,600,0)
    }
}
