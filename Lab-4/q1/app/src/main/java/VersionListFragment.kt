
package com.example.androidversionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.example.androidversions.R

class VersionListFragment : ListFragment() {

    private val androidVersions = arrayOf(
       "Android 10","Android Lollipop","Android 9 Pie","Android 8 Oreo","Android 7 Nougat","Android 6 Marshmallow",
        "Android 12","Android 11"
    )

    private val androidIcons = intArrayOf(
        R.drawable.android_10,
        R.drawable.android5lollipop,
        R.drawable.android_9_0_pie,
        R.drawable.android_8_oreo,
        R.drawable.android_7_nougat,
        R.drawable.android_6_marshmallow,
        R.drawable.android_12,
        R.drawable.android_11,
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val versionItems = mutableListOf<Pair<String, Int>>()

        // Combine Android versions and icons into pairs
        for (i in androidVersions.indices) {
            versionItems.add(Pair(androidVersions[i], androidIcons[i]))
        }

        val adapter = VersionListAdapter(requireContext(), versionItems)
        listAdapter = adapter

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
    }
}
