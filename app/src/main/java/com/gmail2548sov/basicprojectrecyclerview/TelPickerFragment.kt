package com.gmail2548sov.basicprojectrecyclerview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import java.util.*

class TelPickerFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(activity).inflate(R.layout.image_dialog, null)
        return AlertDialog.Builder(activity)
            .setView(view)
            .setTitle(R.string.tel_picker_title)
            .setPositiveButton(android.R.string.ok,null)
            .create()
    }
}