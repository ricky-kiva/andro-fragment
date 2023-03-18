package com.rickyslash.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 'Inflate' the 'layout' for this 'Fragment'
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_category) {
            val detailCategoryFragment = DetailCategoryFragment()

            // 'Bundle()' is an object that 'sends data' between 'Fragment'
            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle Category")
            val lifestyleDesc = "This category is about product in lifestyle"

            // passing the 'Bundled' data from 'Bundle' to 'arguments' of 'detailCategoryFragment'
            detailCategoryFragment.arguments = bundle
            // You could also 'set the variable' 'directly' using 'Getter/Setter'
            detailCategoryFragment.desc = lifestyleDesc

            val fragmentManager = parentFragmentManager
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }


}