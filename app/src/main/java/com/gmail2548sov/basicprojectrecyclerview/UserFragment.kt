package com.gmail2548sov.basicprojectrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user.view.*
import java.util.*
import kotlin.collections.ArrayList


class UserFragment: Fragment() {

    companion object{
        final val FRAGMENT_USER_ID:String = "fragment_user_id"

        fun newInstance(id:UUID): Fragment {
            val args:Bundle = Bundle()
            args.putSerializable(FRAGMENT_USER_ID, id)
            val fragment = UserFragment()
            fragment.arguments = args
            return fragment
        }
    }

    var mDataClass: DatfClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //var id = activity?.intent?.getSerializableExtra(MainActivity.ID_USER) as UUID
        var id = arguments?.getSerializable(FRAGMENT_USER_ID) as UUID
        mDataClass = SingltonUsers.getUser(id)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_user, container, false)
        view.user_id.text = mDataClass?.id.toString()
        return view
    }

}