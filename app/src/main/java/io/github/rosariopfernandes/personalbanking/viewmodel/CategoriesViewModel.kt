package io.github.rosariopfernandes.personalbanking.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import io.github.rosariopfernandes.personalbanking.model.Category
import io.github.rosariopfernandes.personalbanking.util.BankingDatabase

class CategoriesViewModel(val app:Application) : AndroidViewModel(app) {

    var categories: LiveData<List<Category>>? = null
    var database: BankingDatabase? = null

    init {
        database = BankingDatabase.getInstance(app.applicationContext)
        categories = database!!.categoryDao().selectAll()
    }

}