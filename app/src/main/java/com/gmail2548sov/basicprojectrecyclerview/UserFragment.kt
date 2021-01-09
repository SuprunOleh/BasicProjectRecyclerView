package com.gmail2548sov.basicprojectrecyclerview

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.CompoundButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user.view.*
import java.util.*


class UserFragment: Fragment(), CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    companion object{
        final val FRAGMENT_USER_ID:String = "fragment_user_id"
        final val DIALOG:String = "DialogTel"
        final val REQUEST_DATA: Int = 0

        fun newInstance(id:UUID): Fragment {
            val args:Bundle = Bundle()
            args.putSerializable(FRAGMENT_USER_ID, id)
            val fragment = UserFragment()
            fragment.arguments = args
            return fragment
        }
    }

    var mDataClass: DatfClass? = null
    lateinit var mDateButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //var id = activity?.intent?.getSerializableExtra(MainActivity.ID_USER) as UUID
        var id = arguments?.getSerializable(FRAGMENT_USER_ID) as UUID
        mDataClass = Singlton.getSinglton(context!!)?.getUser(id)
        Log.d ("1bd1", "getWritableDatabase3")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_user, container, false)
        mDateButton = view.data_dialog_fragment_user
        view.user_id.text = mDataClass?.id.toString()
        updateDate()
        //view?.data_dialog_fragment_user?.text = mDataClass?.dataCreator.toString()
        view.photo.isChecked = mDataClass?.photo?:false
        view.photo.setOnCheckedChangeListener(this)
        view.tel.setOnClickListener(this)
        return view
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        mDataClass?.photo = isChecked
        Log.d("kl555", "${mDataClass?.photo.toString()}")
    }

    override fun onClick(v: View?) {
        val fm = fragmentManager

        val dialogTel = TelPickerFragment.newInstance(mDataClass?.dataCreator)
        dialogTel.setTargetFragment(this, REQUEST_DATA)
        fm?.let { dialogTel.show(it, DIALOG) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode!=RESULT_OK) {return}
        if (requestCode == REQUEST_DATA) {
            val date:Date = data?.getSerializableExtra(TelPickerFragment.EXTRA_DATA) as Date
            mDataClass?.dataCreator = date
            updateDate()
            Log.d ("778899p", "${updateDate()}, 777")
        }
    }

    fun updateDate(){
        mDateButton.text = mDataClass?.dataCreator.toString()
    }

    override fun onPause() {
        val singlton: Singlton? = context?.let { Singlton.getSinglton(it) }
        mDataClass?.let { singlton?.upDateUser(it) }
        Log.d ("1bd1", "getWritableDatabase3")
        super.onPause()

    }

}