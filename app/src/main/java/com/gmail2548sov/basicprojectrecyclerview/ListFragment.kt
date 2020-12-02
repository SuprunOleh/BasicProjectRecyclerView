package com.gmail2548sov.basicprojectrecyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail2548sov.basicprojectrecyclerview.database.UserBaseHelper
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.*
import kotlin.collections.ArrayList

class ListFragment : Fragment() {

    companion object {
        final val SAVED_SUBTITLE_VISIBLE:String = "subtitle"

    }





    lateinit var mRecyclerView: RecyclerView
    var mUserAdapter: UsersAdapter? = null
    var mSubtitleVisible: Boolean = false


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_list,menu)
        val subTitleItem: MenuItem = menu.findItem(R.id.new_item)
        if (mSubtitleVisible) subTitleItem.setTitle(R.string.hide_subtitle)
        else subTitleItem.setTitle(R.string.show_subtitle)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("menu333", "asdfasd ")

        when (item.itemId) {
            R.id.new_user -> {
                val user: DatfClass = DatfClass()
                SingltonUsers.addUser(user)
//                Log.d("menu333", "asdfasd ${user.toString()}")
                val intent = UserPagerActivity.newIntent(context, user.id)
                startActivity(intent)
//                updateUI()
                return true
            }
            R.id.new_item -> {
                Toast.makeText(context, "Item User", Toast.LENGTH_SHORT).show()
                mSubtitleVisible = !mSubtitleVisible
                activity?.invalidateOptionsMenu()
                updateSubtitle()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun updateSubtitle(){

        val userCount = SingltonUsers.mListUsers.size
        var subtitle:String? = getString(R.string.subtitle_format, userCount)
        //val activity_us = activity

        if (!mSubtitleVisible) {subtitle = null}

        val activity_user: AppCompatActivity = activity as AppCompatActivity
        activity_user.supportActionBar?.setSubtitle(subtitle)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d ("1bd1", "${SingltonUsers.mDataBase.toString()}")
        SingltonUsers.addContextBase(context!!.applicationContext)
        Log.d ("1bd1", "${SingltonUsers.mDataBase.toString()}")
        Log.d ("1bd1", "getWritableDatabase2")
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

        if (savedInstanceState!=null) mSubtitleVisible = savedInstanceState.getBoolean(
            SAVED_SUBTITLE_VISIBLE)

        mRecyclerView = view.findViewById(R.id.myRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    fun updateUI() {

        if (mUserAdapter == null) {
            SingltonUsers.mContext = context!!.applicationContext
            mUserAdapter = UsersAdapter(SingltonUsers.mListUsers)
            mRecyclerView.adapter = mUserAdapter
        } else {Log.d ("lk333", "${SingltonUsers.mChange}")
            //mUserAdapter?.notifyItemChanged(SingltonUsers.mChange)
            mUserAdapter?.notifyDataSetChanged()
        }
        updateSubtitle()
    }

    inner class UsersHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        lateinit var mUser: DatfClass

        init {
            view.setOnClickListener(this)
        }

        fun bindingDateUser(dataUser: DatfClass) {
            mUser = dataUser
            view.item_id.text = mUser.id.toString()
            Log.d ("kl444", "${mUser.photo}")
            view.photo.visibility = if (mUser.photo) View.VISIBLE else View.GONE
        }

        override fun onClick(v: View?) {
            //Toast.makeText(context, mUser.id.toString(), Toast.LENGTH_LONG).show()
            //val intent = Intent(activity, MainActivity::class.java)

            val intent = UserPagerActivity.newIntent(context, mUser.id)

            startActivity(intent)

        }

    }

    inner class UsersAdapter(val listUsers: ArrayList<DatfClass>) :
        RecyclerView.Adapter<UsersHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
            val userAdapterInflater = LayoutInflater.from(context)
            val view: View = userAdapterInflater.inflate(R.layout.item_user, parent, false)
            return UsersHolder(view)
        }

        override fun getItemCount(): Int {
            return listUsers.size
        }

        override fun onBindViewHolder(holder: UsersHolder, position: Int) {
            holder.bindingDateUser(listUsers.get(position))
        }

    }


}