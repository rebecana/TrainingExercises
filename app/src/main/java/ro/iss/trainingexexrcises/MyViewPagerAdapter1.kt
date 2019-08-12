package ro.iss.trainingexexrcises

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MyViewPagerAdapter1(fragmentManager: FragmentManager : FragmentManager, private val  numberOfFragments : Int) : FragmentManager() {

    override fun getItem(position : Int) : Fragment {
        return FirstFragment.newInstance()

        override fun getContent() {
            return numberOfFragments()
        }
    }
}