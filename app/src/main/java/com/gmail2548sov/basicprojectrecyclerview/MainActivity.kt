package com.gmail2548sov.basicprojectrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AbstractActivityForFragment() {


    override fun getFragment():Fragment {
       return UserFragment()
   }
}