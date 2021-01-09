package com.gmail2548sov.basicprojectrecyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.user_pager.*
import java.util.*

class UserPagerActivity: AppCompatActivity() {

    companion object {
        final val ID_USER: String = "id_user"

        fun newIntent(context: Context?, id: UUID): Intent {
            val intent = Intent(context, UserPagerActivity::class.java)
            intent.putExtra(UserPagerActivity.ID_USER, id)
            Log.d ("2223", "$id")
            return intent
        }
    }

    lateinit var mViewPager: ViewPager
    val mUsers = Singlton.getSinglton(this)?.getUsers()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d ("1bd1", "getWritableDatabase3")
        Log.d ("1bd1", "{${mUsers.toString()} +    1111}")
        setContentView(R.layout.user_pager)
        mViewPager = pager_view
        Log.d ("1bd1", "{$mViewPager}")

        val fm: FragmentManager = supportFragmentManager
        mViewPager.adapter = (object : FragmentStatePagerAdapter(fm) {
            override fun getItem(position: Int): Fragment {
                Log.d("11123", "${mUsers?.get(position)?.id?.toString()+  555}")
                return mUsers?.get(position)?.id?.let { UserFragment.newInstance(it) }!!
            }
            override fun getCount(): Int {
                return mUsers?.size!!
            }
        })

        for (i in 0..mUsers?.size!!) {
//            Log.d("11123", "${mUsers.get(i).toString()+  555}")
            if (mUsers?.size==0) break
            if (mUsers?.get(i)?.id==intent.getSerializableExtra(ID_USER)) {
                mViewPager.currentItem = i
                break
            }
        }
    }

}

























