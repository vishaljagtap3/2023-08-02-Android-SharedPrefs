package com.bitcodetech.sharedpreferences

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bitcodetech.sharedpreferences.util.Preferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs : SharedPreferences =
            getSharedPreferences("my_pref", Activity.MODE_PRIVATE)

        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putInt("code", 101)
        editor.putString("name", "BitCode")
        editor.putString("last_visited_directory", "somepath")
        editor.commit()

        val code = prefs.getInt("code", -1)
        val name = prefs.getString("name", "NA")

        mt("$code $name")

        Preferences.storeUsername(
            this,
            "vishal"
        )
        mt(Preferences.getUsername(this) ?: "Not Available" )

        val prefNew = getPreferences(Activity.MODE_PRIVATE) //unnamed pref
        prefNew.edit()
            .putString("location", "Erandwane, Pune")
            .commit()

        mt(prefNew.getString("location", "No location found...")!!)
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}