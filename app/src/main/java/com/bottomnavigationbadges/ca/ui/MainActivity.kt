package com.bottomnavigationbadges.ca.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bottomnavigationbadges.ca.R
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val badgeHome: BadgeDrawable = nav_view.getOrCreateBadge(R.id.navigation_home)
        val badgeDashboard: BadgeDrawable = nav_view.getOrCreateBadge(R.id.navigation_dashboard)
        val badgeNotification: BadgeDrawable = nav_view.getOrCreateBadge(R.id.navigation_notifications)

        badgeHome.number = (1..9).random()
        badgeDashboard.number = (1..9).random()
        badgeNotification.number = (1..9).random()

        val badgeColor = ContextCompat.getColor(baseContext,
            R.color.badgeBackgroundColor
        )
        val badgeTextColor = ContextCompat.getColor(baseContext,
            R.color.badgeTextColor
        )

        badgeHome.backgroundColor = badgeColor
        badgeHome.badgeTextColor = badgeTextColor

        badgeDashboard.backgroundColor = badgeColor
        badgeDashboard.badgeTextColor = badgeTextColor

        badgeNotification.backgroundColor = badgeColor
        badgeNotification.badgeTextColor = badgeTextColor
    }
}
