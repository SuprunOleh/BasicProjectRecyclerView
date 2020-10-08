package com.gmail2548sov.basicprojectrecyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_user.view.*
import kotlinx.android.synthetic.main.item_user.*
import kotlinx.android.synthetic.main.item_user.view.*
import kotlinx.android.synthetic.main.item_user.view.photo
import java.util.zip.Inflater

class ListFragment : Fragment() {

    lateinit var mRecyclerView: RecyclerView
    var mUserAdapter: UsersAdapter? = null


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_list,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("menu333", "asdfasd ")


        when (item.itemId) {
            R.id.new_user -> {
                val user: DatfClass = DatfClass()
                SingltonUsers.addUser(user)
                Log.d("menu333", "asdfasd ${user.toString()}")
                val intent = UserPagerActivity.newIntent(context, user.id)

                startActivity(intent)


                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

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
            mUserAdapter = UsersAdapter(SingltonUsers.mListUsers)
            mRecyclerView.adapter = mUserAdapter
        } else {Log.d ("lk333", "${SingltonUsers.mChange}")
            //mUserAdapter?.notifyItemChanged(SingltonUsers.mChange)
            mUserAdapter?.notifyDataSetChanged()
        }


    }

    inner class UsersHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        lateinit var mUser: DatfClass

        init {
            view.setOnClickListener(this)
        }

        fun bindingDateUser(dataUser: DatfClass) {
            mUser = dataUser
            view.item_id.text = mUser.id.toString()
            Log.d ("kl444", "${mUser.poto}")
            view.photo.visibility = if (mUser.poto) View.VISIBLE else View.GONE
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