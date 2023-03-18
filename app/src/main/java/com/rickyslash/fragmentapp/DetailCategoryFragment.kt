package com.rickyslash.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailCategoryFragment : Fragment() {

    private lateinit var tvCategoryName: TextView
    private lateinit var tvCategoryDescription: TextView
    private lateinit var btnProfile: Button
    private lateinit var btnShowDialog: Button

    var desc: String? = null

    // making 'companion object' that's going to be 'assigned' 'data' from 'received arguments'
    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESC)
            desc = descFromBundle
        }

        if (arguments != null) {
            // 'arguments' / 'getArguments()' will 'get' the 'data' from 'Bundle'
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName
            // But this one is 'setter', it will get data from 'getter'
            tvCategoryDescription.text = desc
        }

        btnShowDialog.setOnClickListener {
            // instantiate custom made 'OptionDialogFragment()'
            val optionDialogFragment = OptionDialogFragment()
            // 'childFragmentManager' used for creating 'FragmentManager' in 'parent' (DetailCategoryFragment) of a 'child' fragment (OptionDialogFragment)
            // That being said, it's best for 'DialogFragment()' 'extended class'
            val fragmentManager = childFragmentManager
            // 'show' will show object 'OptionDialogFragment' to screen
            optionDialogFragment.show(fragmentManager, OptionDialogFragment::class.java.simpleName)
        }
    }

    // this is the 'action' that will be 'executed' when 'optionDialogListener' from 'OptionDialogFragment' is called
    // 'internal' is used to make 'property' (optionDialogListener) inside 'OptionDialogFragment' visible in here
    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object  : OptionDialogFragment.OnOptionDialogListener {
        // this function will override 'interface' function inside 'OptionDialogFragment'
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }

}