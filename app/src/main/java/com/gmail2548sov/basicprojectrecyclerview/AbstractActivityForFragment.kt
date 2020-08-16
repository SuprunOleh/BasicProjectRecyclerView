package com.gmail2548sov.basicprojectrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class AbstractActivityForFragment: AppCompatActivity() {

    abstract fun getFragment():Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm: FragmentManager = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {

            fragment = getFragment()
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }
}