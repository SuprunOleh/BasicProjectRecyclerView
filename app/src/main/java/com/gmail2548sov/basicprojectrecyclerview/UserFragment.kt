package com.gmail2548sov.basicprojectrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user.view.*


class UserFragment: Fragment() {

    lateinit var mDataClass:DatfClass
    val mListUsers: ArrayList<DatfClass> = SingltonUsers.mListUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataClass = DatfClass()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_user, container, false)
        view.user_id.text = SingltonUsers.mListUsers[5].id.toString()
        return view

    }

}