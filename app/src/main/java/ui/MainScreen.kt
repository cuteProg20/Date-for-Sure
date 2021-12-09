package ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dateforsure.R
import com.example.dateforsure.fragments.ChatFragment
import com.example.dateforsure.fragments.ExploreFragment
import com.example.dateforsure.fragments.GroupsFragment
import com.example.dateforsure.fragments.ProfileFragment
import kotlinx.android.synthetic.main.bottom_nav.*


class MainScreen : AppCompatActivity() {



    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)



        val exploreFragment = ExploreFragment()
        val groupsFragment = GroupsFragment()
        val chatFragment = ChatFragment()
        val profileFragment = ProfileFragment()


        makeCurrentFragment(exploreFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.explorer -> makeCurrentFragment(exploreFragment)
                R.id.groups -> makeCurrentFragment(groupsFragment)
                R.id.chat -> makeCurrentFragment(chatFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }


}