package com.mtz.awsomedialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class AwsomeDialog(val contxt: Context) {


    fun showComfirmDialog(message: String, onWarningAccept: () -> Unit = {}) {
        val mDialogView =
                LayoutInflater.from(contxt).inflate(R.layout.dialog_comfirm, null)
        val mBuilder = AlertDialog.Builder(contxt)
                .setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        val tvMessage = mDialogView.findViewById<TextView>(R.id.str_message)
        tvMessage.text = message

        val btnYes = mAlertDialog.findViewById<Button>(R.id.btnYes)
        val btnNo = mAlertDialog.findViewById<Button>(R.id.btnNo)
        btnNo?.setOnClickListener {
            mAlertDialog.dismiss()
        }
        btnYes?.setOnClickListener {
            mAlertDialog.dismiss()
            onWarningAccept()
        }

    }
}