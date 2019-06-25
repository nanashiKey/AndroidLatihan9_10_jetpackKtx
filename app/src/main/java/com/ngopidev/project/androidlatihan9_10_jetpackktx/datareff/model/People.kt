package com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/

@Entity
class People (
    var nama : String = "" ,
    var lokasi : String = "",
    var contact : String = "",
    var email : String = "",
    var facebook : String = "",
    var twitter : String = "",
    @PrimaryKey(autoGenerate = true) var id : Int = 0
)

