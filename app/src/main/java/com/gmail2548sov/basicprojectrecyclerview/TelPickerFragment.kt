package com.gmail2548sov.basicprojectrecyclerview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class TelPickerFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setTitle(R.string.tel_picker_title)
            .setPositiveButton(android.R.string.ok,null)
            .create()
    }
}