package com.example.androidversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidversionlist.VersionListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, VersionListFragment())
                .commit()
        }
    }
}
