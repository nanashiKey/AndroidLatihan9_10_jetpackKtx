package com.ngopidev.project.androidlatihan9_10_jetpackktx

import android.app.Application
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.Main2


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/
class StartApp : Application(){
    fun getPeopleRepo() = Main2(this)
}