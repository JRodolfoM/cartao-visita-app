package br.com.jrmantovani.cartaovisita

import android.app.Application
import br.com.jrmantovani.cartaovisita.data.AppDatabase
import br.com.jrmantovani.cartaovisita.data.BusinessCardRepository

class App: Application() {
   val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}
