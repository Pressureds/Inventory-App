package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

//Membuat nama tabel menjadi item
@Entity(tableName = "item")
//mendeklarasikan variabel class item
//kemudian dikonversikan ke class data
data class Item(
    //Membuat primaryKey otomatis
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    //ColumnInfo memastikan nama kolom dengan bidamg tertentu
    @ColumnInfo(name = "name")
    val itemName: String,
    @ColumnInfo(name = "price")
    val itemPrice: Double,
    @ColumnInfo(name = "quantity")
    val quantityInStock: Int)

//Mengembalikan harga yang diteruskan dalam format mata uang
fun Item.getFormattedPrice(): String =
    NumberFormat.getCurrencyInstance().format(itemPrice)
