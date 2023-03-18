package com.rickyslash.fragmentapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

// 'DialogFragment()' is a 'Fragment object' that displays 'floating modal dialog'
class OptionDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbOne: RadioButton
    private lateinit var rbFive: RadioButton
    private lateinit var rbPink: RadioButton
    private lateinit var rbBon: RadioButton

    // assign interface to a variable
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbOne = view.findViewById(R.id.rb_one)
        rbFive = view.findViewById(R.id.rb_five)
        rbPink = view.findViewById(R.id.rb_pink)
        rbBon = view.findViewById(R.id.rb_bon)

        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != 1) {
                var band: String? = when (checkedRadioButtonId) {
                    R.id.rb_one -> rbOne.text.toString().trim()
                    R.id.rb_five -> rbFive.text.toString().trim()
                    R.id.rb_pink -> rbPink.text.toString().trim()
                    R.id.rb_bon -> rbBon.text.toString().trim()
                    else -> null
                }
                // 'assigning' the 'chosen radio' to the 'interface's method'
                optionDialogListener?.onOptionChosen(band)
                // will 'dismiss' the 'Dialog Fragment'
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener {
            // will 'close' the 'Dialog Fragment'
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            // 'fragment.optionDialogListener' from 'DetailCategoryFragment' is connected to 'this.optionDialogListener'
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    // making 'interface' for 'handling event'
    interface  OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

}