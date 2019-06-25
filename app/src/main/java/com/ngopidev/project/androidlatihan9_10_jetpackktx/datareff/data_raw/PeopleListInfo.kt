package com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.data_raw

import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/
class PeopleListInfo {
    companion object {
        var peopleListInfo = initPeopleList()

        fun initPeopleList() : MutableList<People>{
            var po_peoples = mutableListOf<People>()
            po_peoples.add(
                People(
                    "peter",
                    "Manhattan",
                    "021101112",
                    "peter123@gmail.com",
                    "fb.me/peter",
                    "twitter.me/peter",
                    id = 1
                )
            )
            po_peoples.add(
                People(
                    "retep",
                    "nattahnam",
                    "021101112",
                    "retep321@gmail.com",
                    "fb.me/peter",
                    "twitter.me/peter",
                    id = 2
                )
            )
            po_peoples.add(
                People(
                    "spiderman",
                    "Manhattan",
                    "02633210010",
                    "spder@gmail.com",
                    "fb.me/peter",
                    "twitter.me/peter",
                    id = 3
                )
            )
            return po_peoples
        }
    }
}