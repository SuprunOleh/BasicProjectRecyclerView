package com.gmail2548sov.basicprojectrecyclerview

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.date_dialog.view.*
import java.util.*

class TelPickerFragment: DialogFragment() {


    lateinit var mPicker: DatePicker

    companion object {
        final val TEL_DATE: String = "tel_date"
        final val EXTRA_DATA:String = "com.gmail.2548sov.new_date"

        fun newInstance(data: Date?): TelPickerFragment {
            val args: Bundle = Bundle()
            args.putSerializable(TEL_DATE, data)
            val fragment_Dialog: TelPickerFragment = TelPickerFragment()
            fragment_Dialog.arguments = args
            return fragment_Dialog
        }
    }

    private fun sendResult (resultCode: Int, date:Date) {
        if (targetFragment == null) {return}
        val intent: Intent = Intent()
        intent.putExtra(EXTRA_DATA, date)
        targetFragment?.onActivityResult(targetRequestCode, resultCode, intent)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val data: Date = arguments?.getSerializable(TEL_DATE) as Date
        var calendar: Calendar = Calendar.getInstance()
        calendar.time = data
        val year: Int = calendar.get(Calendar.YEAR)
        val month: Int = calendar.get(Calendar.MONTH)
        val day: Int =  calendar.get(Calendar.DAY_OF_MONTH)


        //val view = LayoutInflater.from(activity).inflate(R.layout.image_dialog, null)
        val view_date = LayoutInflater.from(activity).inflate(R.layout.date_dialog, null)

        mPicker = view_date.date
        mPicker.init(year,month,day,null)

        return AlertDialog.Builder(activity)
            .setView(view_date)
            .setTitle(R.string.tel_picker_title)
            .setPositiveButton(android.R.string.ok, (object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    val year: Int = mPicker.year
                    val month: Int = mPicker.month
                    val day: Int =  mPicker.dayOfMonth
                    val date:Date = GregorianCalendar(year,month,day).time
                    sendResult(RESULT_OK, date)

                }

            }))
            .create()
    }
}