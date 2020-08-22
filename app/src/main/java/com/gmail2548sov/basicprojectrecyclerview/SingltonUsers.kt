package com.gmail2548sov.basicprojectrecyclerview

import android.content.Context
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

object SingltonUsers {
    val mListUsers: ArrayList<DatfClass> = ArrayList()
    lateinit var context: Context
    var mChange: Int = 0


    init {
        for (i: Int in 0..99) {
            mListUsers.add(DatfClass())
            Log.d ("mDataList", mListUsers[i].toString())
        }
    }

    fun getUser(id:UUID): DatfClass? {
        for (i in mListUsers) {
            mChange++
            if (i.id==id) {return i}
        }
        return null
    }

}