package com.gmail2548sov.basicprojectrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.zip.Inflater

class ListFragment: Fragment() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var mUserAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_list,container,false)

        mRecyclerView = view.findViewById(R.id.myRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    fun updateUI(){
        mUserAdapter = UsersAdapter(SingltonUsers.mListUsers)
        mRecyclerView.adapter = mUserAdapter
    }

    inner class UsersHolder(val view:View): RecyclerView.ViewHolder(view), View.OnClickListener {

        lateinit var mUser:DatfClass

        init{
            view.setOnClickListener(this)
        }

        fun bindingDateUser(dataUser:DatfClass){
            mUser = dataUser
            view.item_id.text = dataUser.id.toString()
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, mUser.id.toString(), Toast.LENGTH_LONG).show()
        }




    }

    inner class UsersAdapter(val listUsers: ArrayList<DatfClass>):RecyclerView.Adapter<UsersHolder>() {

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