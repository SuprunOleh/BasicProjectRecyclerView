package com.gmail2548sov.basicprojectrecyclerview

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.gmail2548sov.basicprojectrecyclerview.database.UserBaseHelper
import java.util.*
import kotlin.collections.ArrayList


class Singlton private constructor(context: Context) {
    private val mContext: Context
    private val mDatabase: SQLiteDatabase
    val crimes: List<DatfClass> = ArrayList()

    init {
        mContext = context.applicationContext
        mDatabase = UserBaseHelper(mContext).getWritableDatabase()
    }

    fun addCrime(c: DatfClass?) {}



    fun getCrime(id: UUID?): DatfClass? {
        return null
    }

    companion object {
        private val sCrimeLab: Singlton? = null
    }

}
