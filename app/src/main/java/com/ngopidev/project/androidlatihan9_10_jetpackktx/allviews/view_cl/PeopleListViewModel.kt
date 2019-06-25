package com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_cl

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.ngopidev.project.androidlatihan9_10_jetpackktx.StartApp
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/
class PeopleListViewModel(application: Application) :AndroidViewModel(application) {
    private val peopleRepo = getApplication<StartApp>().getPeopleRepo()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList() : LiveData<List<People>>{
        return peopleList
    }

    fun getAllPeople(){
        peopleList.addSource(peopleRepo.getAllPeople()){
            peoples -> peopleList.postValue(peoples)
        }
    }
}