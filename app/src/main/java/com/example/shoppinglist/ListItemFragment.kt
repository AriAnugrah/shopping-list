package com.example.shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.config.itemLists
import kotlinx.android.synthetic.main.fragment_list_item.*


class ListItemFragment(private val OnNavigationListener: OnNavigationListener) : Fragment() {

    private lateinit var addItemFragment: AddItemFragment
    private lateinit var onNav: OnNavigationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onNav = activity as OnNavigationListener
        addItemFragment = AddItemFragment(onNav)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycle_view.adapter = Adapter(itemLists)
        recycle_view.layoutManager = LinearLayoutManager(context)
        recycle_view.setHasFixedSize(true)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ItemAddButton.setOnClickListener{
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, addItemFragment)?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_item, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) = ListItemFragment(onNavigationListener)
    }

}