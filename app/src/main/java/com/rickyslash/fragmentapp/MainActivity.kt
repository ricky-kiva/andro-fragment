package com.rickyslash.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 'FragmentManager' is a 'class' responsible to 'organize Fragment' into an 'Activity'
        val fragmentManager = supportFragmentManager
        // Instantiate 'HomeFragment' class that is made 'custom' by us
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        // the first attempt of assigning 'fragment variable' (above) will always be null
        // this means the 'if statement' will always be called in the beginning
        // the 'Tag' will be added by '.add' inside this if statement
        // the naming of the 'Tag' will has the 'same name' as the 'class' file, which is "HomeFragment"
        if (fragment !is HomeFragment) {
            Log.d("FragmentApp", "Fragment Name: " + HomeFragment::class.java.simpleName)
            fragmentManager
                .beginTransaction() // 'initiate' the 'FragmentManager'
                .add(R.id.frame_container, homeFragment) // 'add' will create a new instance of the HomeFragment class & add it to FragmentManager
                .commit() // 'start' the 'FragmentManager'
        }

    }
}

// Fragment is an 'UI component' that has 'almost the same' form as 'Activity'
// The difference is:
// - The 'class' is 'extended' (inherited) to 'Fragment'
// - 'Don't need' to be 'registered' to 'AndroidManifest.xml'

// 'Advantage' of using 'Fragment':
// - can make 'multiple kind of UI' 'without moving activity'
// - It is 'reusable', means it could be used on multiple activity
// It could make multiple type of UI because 'Fragment' is 'Modular'. Means it involves a module to be the basis of a design

// Action such 'add()', 'replace()', 'remove()',  and 'addToBackStack()' could be integrated to 'Fragment'
// 'addToaBckStack()' could save 'add Fragment "Transaction" to stack', which will allow us when clicking 'Back Nav Button' 'not to jump to MainActivity' but the 'last Fragment'

// A Fragment 'depends' on the 'lifecycle of activity where it is integrated'
// The 'lifecycle' of 'Fragment', respectively to 'Activity's state':
// - (Activity) Created: onAttach(), onCreate(), onCreateView(), onActivityCreated()
// - (Activity) Started: onStart()
// - (Activity) Resumed: onResume()
// --- Resumed: 'Fragment' 'could be seen' when 'activity' is 'running'
// - (Activity) Paused: onPause()
// - (Activity) Stopped: onStop()
// --- Stopped: When 'activity' is 'not seen on screen', 'Fragment is still alive with the information it got',  whether the 'activity is stopped' or the 'fragment is removed from activity'
// - (Activity) Destroyed: onDestroyView(), onDestroy(), onDetach()

// 'Fragment' 'difference' compared to 'Activity' by 'code':
// - Context -> this = requireActivity() (Kotlin) / getActivity() (Java)
// - Main function -> onCreate = onViewCreated
// - Take 'View' -> findViewById = view.findViewById