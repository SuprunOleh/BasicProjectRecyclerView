package com.gmail2548sov.basicprojectrecyclerview.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.gmail2548sov.basicprojectrecyclerview.database.UserDbSchema.UserTable
import com.gmail2548sov.basicprojectrecyclerview.database.UserDbSchema.UserTable.Cols

class UserBaseHelper(val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, VERSION) {

    companion object {
        const val VERSION: Int = 1
        const val DATABASE_NAME: String = "userBase.db"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "create table " + UserTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    Cols.UUID + ", " +
                    Cols.DATE + ", " +
                    Cols.NAME + ", " +
                    Cols.PHOTO +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}