package com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff

import android.app.Application
import android.arch.lifecycle.LiveData
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.databases.PeoplDB
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.databases.PeopleDAO
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/
class Main2 (application: Application){
    private val peopleDAO : PeopleDAO

    init {
        val peopleDB = PeoplDB.getInstance(application)
        peopleDAO = peopleDB.peopleDao()
    }

    fun getAllPeople(): LiveData<List<People>>{
        return peopleDAO.getAll()
    }

    fun insertPeople(people: People){
        peopleDAO.insert(people)
    }

    fun findPeople(id : Int) : People?{
        return peopleDAO.find(id)
    }
}