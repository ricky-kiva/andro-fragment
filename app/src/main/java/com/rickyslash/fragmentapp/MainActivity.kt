package com.rickyslash.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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