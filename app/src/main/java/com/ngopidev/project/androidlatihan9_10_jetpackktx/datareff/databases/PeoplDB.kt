package com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.databases

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.data_raw.PeopleListInfo
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/

@Database(entities = [People::class], version = 1)
abstract class PeoplDB : RoomDatabase() {
    abstract fun peopleDao() : PeopleDAO

    companion object {
        private val lock = Any()
        private const val DB_NAME = "people.db"
        private var INSTANCE: PeoplDB? = null

        fun getInstance(application: Application) : PeoplDB{
            synchronized(lock){
                if (PeoplDB.INSTANCE == null){
                    PeoplDB.INSTANCE =
                            Room.databaseBuilder(application,
                                PeoplDB::class.java, PeoplDB.DB_NAME)
                                .allowMainThreadQueries()
                                .addCallback(object  : RoomDatabase.Callback(){
                                    override fun onCreate(db: SupportSQLiteDatabase) {
                                        super.onCreate(db)
                                        PeoplDB.INSTANCE?.let{
                                            PeoplDB.prePopulated(it,
                                                PeopleListInfo.peopleListInfo)
                                        }
                                    }
                                }).build()
                }
            }
            return INSTANCE!!
        }

        fun prePopulated(db : PeoplDB, peopleList : List<People>){
            for (people in peopleList){
                AsyncTask.execute { db.peopleDao().insert(people) }
            }
        }

    }
}