package com.gmail2548sov.basicprojectrecyclerview

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import java.util.*

class MainActivity : AbstractActivityForFragment() {
    lateinit var mId: UUID

    companion object{
        final val ID_USER: String = "id_user"

        fun newIntent (context: Context?, id: UUID): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(MainActivity.ID_USER, id)
            return intent
        }
    }




    override fun getFragment():Fragment {
        //  val intent = Intent()
        mId = intent.getSerializableExtra(ID_USER) as UUID
        return UserFragment.newInstance(mId)
   }
}