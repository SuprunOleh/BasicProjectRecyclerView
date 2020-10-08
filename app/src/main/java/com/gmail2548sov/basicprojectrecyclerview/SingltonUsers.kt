package com.gmail2548sov.basicprojectrecyclerview

import android.content.Context
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

object SingltonUsers {
    val mListUsers: ArrayList<DatfClass> = ArrayList()
    lateinit var context: Context
    var mChange: Int = 0


    fun addUser(user: DatfClass) {
        mListUsers.add(user)
    }


//    init {
//
//        for (i: Int in 0..99) {
//            val user: DatfClass = DatfClass()
//            user.poto = i%2 == 0
//            Log.d ("datd333", "${user.dataCreator.toString()}")
//            mListUsers.add(user)
//
//            Log.d ("mDataList", mListUsers[i].toString())
//        }
//    }

    fun getUser(id:UUID): DatfClass? {
        for (i in mListUsers) {

            if (i.id==id) {
                return i}
        }
        return null
    }

}