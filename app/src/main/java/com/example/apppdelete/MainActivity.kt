package com.example.apppdelete

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.apppdelete.databinding.ActivityHomeBinding
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var news: NewsFragment
    lateinit var icMenu: ImageView
    lateinit var activityHomeBinding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setContentView(activityHomeBinding.root)

        initViews()


        //Menu Click
        icMenu.setOnClickListener {

            activityHomeBinding.drawerLayout.open()
        }

    }

    private fun initViews() {
        icMenu = findViewById(R.id.ic_menu)
    }

    fun pushFragment(fragment: Fragment, addToBackStack: Boolean = false) {

        var fragment = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_Container, fragment)

        if (addToBackStack) {
            fragment.addToBackStack("j")
        }
        fragment.commit()
        activityHomeBinding.drawerLayout.close()
    }
}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val appBarLayout = findViewById<AppBarLayout>(R.id.appbar)
//        val titleTextView = findViewById<TextView>(R.id.title)
//
//        val initialPadding = resources.getDimensionPixelSize(R.dimen.initial_padding)
//        val expandedPadding = resources.getDimensionPixelSize(R.dimen.expanded_padding)
//        val bottom = resources.getDimensionPixelSize(R.dimen.bottom)
//
//
//        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//            val maxScroll = appBarLayout.totalScrollRange
//            val percentage = (Math.abs(verticalOffset).toFloat() / maxScroll.toFloat())
//
//            val titleTextSize = 16 + (8 * percentage)
//            val titleTextColor = ColorUtils.blendARGB(Color.BLACK, Color.WHITE, percentage)
//
//            titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleTextSize)
//            titleTextView.setTextColor(titleTextColor)
//
//            val currentPadding = if (percentage > 0.5) expandedPadding else initialPadding
//            titleTextView.setPadding(currentPadding, bottom, currentPadding, 0)
//
//        })
//    }
//}