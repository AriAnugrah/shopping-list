package com.example.shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cardview.*
import kotlinx.android.synthetic.main.fragment_add_item.*

class AddItemFragment(private val onNavigationListener: OnNavigationListener) : Fragment() {

    private lateinit var listItemFragment: ListItemFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_submit.setOnClickListener {
            val itemName = input_itemname.text
            val itemPrice = input_itemprice.text
            val itemQuantity = input_itemquantity.text
            val itemDesc = input_itemdesc.text
            onNavigationListener.onAddList(
                    ItemName = itemName.toString(),
                    ItemPrice = itemPrice.toString(),
                    ItemQuantity = itemQuantity.toString(),
                    ItemDescription = itemDesc.toString()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) = AddItemFragment(onNavigationListener)
    }
}