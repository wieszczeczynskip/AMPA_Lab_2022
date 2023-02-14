package com.example.ampa_lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity()
//    , StaticFragment.OnSelectListener
{
    var bold: Boolean = false

    companion object {
        var italics = false
    }
//    var frag1: Fragment1? = null
//    var frag2: Fragment2? = null
//    var myTrans: FragmentTransaction? = null
//
//    private val TAG_F1 = "Fragment1"
//    private val TAG_F2 = "Fragment2"
//    val navHostFragment = supportFragmentManager.findFragmentById(R.id.navContainer)
//    val navController = navHostFragment?.findNavController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        theme.applyStyle(R.style.MyTheme1,true)
        setContentView(R.layout.activity_main)

        val bottom_navigation = findViewById<View>(R.id.bottom_nav) as BottomNavigationView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navContainer)
        val navController = navHostFragment?.findNavController()

        val appBarConfig =
            AppBarConfiguration(setOf(R.id.left_frag,R.id.center_frag,R.id.right_frag,R.id.rightright_frag))
        if (navController != null) {
            setupActionBarWithNavController(navController,appBarConfig)
        }
        if (navController != null) {
            bottom_navigation.setupWithNavController(navController)
        }

//        if(savedInstanceState == null) {
//            frag1 = Fragment1.newInstance("asd", "asd")
//            frag2 = Fragment2.newInstance("asd", "asd")
//
//            myTrans = supportFragmentManager.beginTransaction()
//            myTrans!!.add(R.id.dfcontainer, frag1!!, this.TAG_F1)
//            myTrans!!.detach(frag1!!)
//            myTrans!!.add(R.id. dfcontainer, frag2!!, this.TAG_F2)
//            myTrans!!.detach(frag2!!)
//            myTrans!!.commit()
//        }
//        else {
//            frag1 = supportFragmentManager.findFragmentByTag(this.TAG_F1) as Fragment1?
//            frag2 = supportFragmentManager.findFragmentByTag(this.TAG_F2) as Fragment2?
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.pozycja1 -> {
                theme.applyStyle(R.style.Theme_AMPA_Lab_4,true)
                true;
            }
            R.id.pozycja2 -> {
                theme.applyStyle(R.style.MyTheme1,true)
                true;
            }
            R.id.pozycja3 -> {
                theme.applyStyle(R.style.MyTheme2,true)
                true;
            }
            else -> super.onContextItemSelected(item)
        }
    }

//    override fun onSelect(option: Int) {
//        val myTrans = supportFragmentManager.beginTransaction();
//        when (option) {
//            1 -> {
//                myTrans.detach(frag2!!)
//                myTrans.attach(frag1!!)
//            }
//            2 -> {
//                myTrans.detach(frag1!!)
//                myTrans.attach(frag2!!)
//            }
//        }
//        myTrans.commit()
//    }
}