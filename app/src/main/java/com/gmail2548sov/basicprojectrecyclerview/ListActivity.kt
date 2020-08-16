package com.gmail2548sov.basicprojectrecyclerview

import androidx.fragment.app.Fragment

class ListActivity: AbstractActivityForFragment() {

    override fun getFragment(): Fragment{
        return ListFragment()
    }

}