// VersionListAdapter.kt
package com.example.androidversionlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidversions.R

class VersionListAdapter(context: Context, private val versionItems: List<Pair<String, Int>>) :
    ArrayAdapter<Pair<String, Int>>(context, R.layout.version_list_item, versionItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.version_list_item, parent, false)
        }

        val currentVersionItem = versionItems[position]

        val versionNameTextView: TextView = itemView!!.findViewById(R.id.versionNameTextView)
        val versionIconImageView: ImageView = itemView.findViewById(R.id.versionIconImageView)

        versionNameTextView.text = currentVersionItem.first
        versionIconImageView.setImageResource(currentVersionItem.second)

        return itemView
    }
}
