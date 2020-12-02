package com.gmail2548sov.basicprojectrecyclerview.database

import android.database.Cursor
import android.database.CursorWrapper
import com.gmail2548sov.basicprojectrecyclerview.DatfClass

class UserCursorWrapper(cursor: Cursor) : CursorWrapper(cursor) {

    fun getUser():DatfClass? {
        val uuidString:String = getString(getColumnIndex(UserDbSchema.UserTable.Cols.UUID))
        val name:String = getString(getColumnIndex(UserDbSchema.UserTable.Cols.NAME))
        val date:Long = getLong(getColumnIndex(UserDbSchema.UserTable.Cols.DATE))
        val isPhoto:Int = getInt(getColumnIndex(UserDbSchema.UserTable.Cols.PHOTO))
        return null
    }

}