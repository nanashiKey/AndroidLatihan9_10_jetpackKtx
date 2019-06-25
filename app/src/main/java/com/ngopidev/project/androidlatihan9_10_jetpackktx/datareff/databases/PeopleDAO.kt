package com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.databases

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/

@Dao
interface PeopleDAO {
    //query get all data from sqlite
    @Query("select * from people order by id desc")
    fun getAll() : LiveData<List<People>>

    //query insert to database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people : People)

    //query delete
    @Query("delete from people")
    fun deleteAll()

    //query select by id
    @Query("select * from people where id = :id")
    fun find(id : Int) : People

}