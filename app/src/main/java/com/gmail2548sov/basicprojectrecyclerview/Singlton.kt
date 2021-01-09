package com.gmail2548sov.basicprojectrecyclerview

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.gmail2548sov.basicprojectrecyclerview.database.UserBaseHelper
import com.gmail2548sov.basicprojectrecyclerview.database.UserCursorWrapper
import com.gmail2548sov.basicprojectrecyclerview.database.UserDbSchema
import com.gmail2548sov.basicprojectrecyclerview.database.UserDbSchema.UserTable
import com.gmail2548sov.basicprojectrecyclerview.database.UserDbSchema.UserTable.Cols
import java.util.*
import kotlin.collections.ArrayList


class Singlton private constructor(context: Context) {
    private val mContext: Context
    private val mDatabase: SQLiteDatabase

    var mChange: Int = 0

    init {
        mContext = context.applicationContext
        mDatabase = UserBaseHelper(mContext).getWritableDatabase()
    }

    //-----------------------------------------

    fun addUser(c: DatfClass) {
        Log.d("get222", "${c.toString()} + 1112")
        Log.d("get222", "${mDatabase.toString()} + 1112")

        val values: ContentValues = getContentValues(c)
        Log.d("get222", "${values.toString()} + 11192")

        var _id: Long = mDatabase.insert(UserTable.NAME, null, values)
        Log.d("get222", "${_id} + 11193")


    }

    fun getUsers():ArrayList<DatfClass> {
        val users: ArrayList<DatfClass> = ArrayList()
        Log.d ("userCursor222","${users.size.toString()} +   1")

        val userCursor = queryUsers(null,null)
        Log.d ("userCursor222","${userCursor.toString()} +   1q")
        try {
            userCursor?.moveToFirst()
            while (!userCursor?.isAfterLast()!!) {
                userCursor.getUser()?.let { users.add(it) }
                Log.d ("userCursor222","${userCursor.getUser().toString() +   1234}")
                userCursor.moveToNext()
            }
        } finally {
            userCursor?.close()
        }
        return users
    }

    fun getUser(id: UUID?): DatfClass? {
        val userCursor = queryUsers(UserTable.Cols.UUID + "=?",  arrayOf(id.toString()) )

        try {
            if (userCursor?.count == 0) {
                return null
            }

            userCursor?.moveToFirst()
            return userCursor?.getUser()
        } finally {
            userCursor?.close()
        }

    }

    fun upDateUser(user:DatfClass) {
        val uuidString:String = user.id.toString()
        val values: ContentValues = getContentValues(user)
        mDatabase?.update(UserTable.NAME, values, Cols.UUID + " = ?", arrayOf(uuidString))
    }


    private fun queryUsers(whereClause: String?, whereArgs: Array<String>?): UserCursorWrapper? {
        Log.d ("userCursor222","${mDatabase.toString()}+222")
        val cursor: Cursor = mDatabase.query(UserDbSchema.UserTable.NAME, null, whereClause, whereArgs, null, null, null)
        Log.d ("user223","${cursor.toString()} + 1")
        Log.d ("user223","${cursor?.getColumnIndex(UserTable.Cols.PHOTO)} + 12")
       // Log.d ("user223","ID = + ${cursor?.getString(cursor?.getColumnIndex(UserTable.Cols.UUID))} + 13")
        return UserCursorWrapper(cursor)
    }



    //----------------------------------------------

    companion object {
        private var sCrimeLab: Singlton? = null

        fun getSinglton(context: Context): Singlton? {
            if (sCrimeLab == null) {sCrimeLab = Singlton(context)}
            return sCrimeLab
        }

        private fun getContentValues(user:DatfClass): ContentValues {
            val values:ContentValues = ContentValues()
            values.put(Cols.UUID, user.id.toString())
            values.put(Cols.NAME, user.name.toString())
            values.put(Cols.DATE, user.dataCreator.time)
            values.put(Cols.PHOTO, when(user.photo){
                true -> 1;
                false -> 0;
            })
            Log.d("get222", "${values.toString()} + 11123")
            return values
        }
    }

}
