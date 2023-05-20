package com.example.inventory

import android.app.Application
import com.example.inventory.data.ItemRoomDatabase

//membuat instance database di class Application
class InventoryApplication : Application(){
    //'by lazy' agar database dan repository dibuat
    //saat dibutuhkan saja tidak ketika aplikasi dijalankan
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}
