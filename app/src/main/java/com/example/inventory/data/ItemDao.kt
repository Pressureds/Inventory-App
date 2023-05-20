package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//Dao digunakan untuk mengakses Inventory database
@Dao
interface ItemDao {

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * from item WHERE id = :id")
    //memastikan mendapatkan notifikasi setiap data dalam database berubah
    fun getItem(id: Int): Flow<Item>

    //OnConflict Ignore akan memberitahu room untuk mengabaikan item baru
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    //Memperbaharui Item
    @Update
    suspend fun update(item: Item)

    //Menghapus item
    @Delete
    suspend fun delete(item: Item)

}
