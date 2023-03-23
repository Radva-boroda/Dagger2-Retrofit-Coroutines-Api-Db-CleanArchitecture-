package dev.ronnie.imageloaderdagger2.api.repository

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.ronnie.imageloaderdagger2.presentation.fragments.PicturesFragment

class ViewPagerAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int { Log.i("ViewPager","Arrival_OF_Elements")// скільки фрагментів
        return 1
    }
    override fun createFragment(position: Int): Fragment {
        Log.i("createFragment", "Sending_for_processing_to_PicturesFragment")
        return PicturesFragment()
    }
}


