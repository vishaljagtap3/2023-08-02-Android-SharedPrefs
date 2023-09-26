package com.bitcodetech.sharedpreferences.util

import android.app.Activity
import android.content.Context

object Preferences {

    private val USER_PREF_NAME = "user_preferences"
    private val KEY_USERNAME = "username"


    fun storeUsername(context : Context, username : String) {
        val prefs = context.getSharedPreferences(
            USER_PREF_NAME,
            Activity.MODE_PRIVATE
        )

        prefs.edit()
            .putString(KEY_USERNAME, username)
            .commit()

    }

    fun getUsername(context: Context) =
        context.getSharedPreferences(
            USER_PREF_NAME,
            Activity.MODE_PRIVATE
        ).getString(KEY_USERNAME, null)

}