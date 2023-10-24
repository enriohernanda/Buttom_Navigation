package com.example.buttom_navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var meowBottomNavigation: MeowBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meowBottomNavigation = findViewById(R.id.meowBottom)

        setFragment(HomeFragment.newIntance())
        meowBottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.icon_home))
        meowBottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.icon_video))
        meowBottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.icons_feedback))
        meowBottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.icon_about))

        meowBottomNavigation.setOnShowListener {
            when (it.id) {
                1 -> setFragment(HomeFragment.newIntance())
                2 -> setFragment(VideoFragment.newIntance())
                3 -> setFragment(FeedbackFragment.newIntance())
                4 -> setFragment(AboutFragment.newIntance())

                else -> " "
            }
        }
        meowBottomNavigation.show(1)
    }
    fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,fragment)
            .commit()
    }
}