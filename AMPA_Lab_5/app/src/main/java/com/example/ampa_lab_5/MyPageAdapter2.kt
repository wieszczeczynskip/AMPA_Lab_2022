package com.example.ampa_lab_5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter2(fg: Fragment): FragmentStateAdapter(fg) {
    val PAGE_COUNT = 2
    override fun createFragment(page: Int): Fragment {
        return Image1Fragment.newInstance(page)
    }
    override fun getItemCount(): Int {
        return PAGE_COUNT
    }
}
