package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.shoppinglist.config.itemLists

class MainActivity : AppCompatActivity(), OnNavigationListener {

    private lateinit var splashFragment: SplashFragment
    private lateinit var listItemFragment: ListItemFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)

        splashFragment = SplashFragment.newInstance(this)
        switchFragment(splashFragment)

    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onAddList(ItemName: String, ItemPrice: String, ItemQuantity: String, ItemDescription: String) {
        val item = ItemList(ItemName, ItemPrice, ItemQuantity, ItemDescription)
        itemLists.add(item)
        listItemFragment = ListItemFragment.newInstance(this)
        switchFragment(listItemFragment)
    }


    override fun onSplash() {
        listItemFragment = ListItemFragment.newInstance(this)
        switchFragment(listItemFragment)
    }
}