package com.gmail2548sov.basicprojectrecyclerview

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.gmail2548sov.basicprojectrecyclerview.database.UserBaseHelper
import com.gmail2548sov.basicprojectrecyclerview.database.UserDbSchema
import java.util.*
import kotlin.collections.ArrayList

object SingltonUsers {

    lateinit var mContext: Context
    var mDataBase: SQLiteDatabase? = null
    val mListUsers: ArrayList<DatfClass> = ArrayList()

    var mChange: Int = 0





//    fun addContextBase(context: Context){
//        mContext = context
//        mDataBase = UserBaseHelper(context).getWritableDatabase()
//        Log.d ("1bd1", "getWritableDatabase")
//
//    }
//
//    fun addUser(user: DatfClass) {
//        val values:ContentValues = getContentValues(user)
//        mDataBase?.insert(UserDbSchema.UserTable.NAME, null, values)
//    }
//
//    fun getUser(id:UUID): DatfClass? {
//
//        return null
//    }
//
//    fun getContentValues(user:DatfClass): ContentValues {
//        val values: ContentValues = ContentValues()
//        values.put(UserDbSchema.UserTable.Cols.UUID, user.id.toString())
//        values.put(UserDbSchema.UserTable.Cols.NAME, user.name)
//        values.put(UserDbSchema.UserTable.Cols.DATE, user.dataCreator.toString())
//        values.put(UserDbSchema.UserTable.Cols.PHOTO, if(user.photo) 1 else 0)
//
//        return values
//    }
//
//
//
//    fun upDateUser(user:DatfClass) {
//        val uuidString:String = user.id.toString()
//        val values:ContentValues = getContentValues(user)
//        mDataBase?.update(UserDbSchema.UserTable.NAME, values, UserDbSchema.UserTable.Cols.UUID + " = ?", arrayOf(uuidString))
//    }



}