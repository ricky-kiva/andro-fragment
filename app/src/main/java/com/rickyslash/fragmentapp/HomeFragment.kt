package com.rickyslash.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_category) {
            // instantiate custom 'CategoryFragment' class
            val categoryFragment = CategoryFragment()
            // 'parent'FragmentManager used when the Fragment is hosted in 'nested Fragment'
            // This allow us to get 'FragmentManager' from 'Activity' (the 'supportFragmentManager')
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                // 'replace' will 'change' the 'fragment object' within 'given id'
                replace(R.id.frame_container, categoryFragment, CategoryFragment::class.java.simpleName)
                addToBackStack(null) // give 'addToBackStack()' functionality. The name of the process is not assigned (null)
                commit()
            }
        }
    }

}