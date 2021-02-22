package com.example.shoppinglist

interface OnNavigationListener {

    fun onAddList(ItemName: String, ItemPrice: String, ItemQuantity: String, ItemDescription: String)
    fun onSplash()
}