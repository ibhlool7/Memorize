package com.iman.memorize.utils.network

import android.os.AsyncTask
import android.util.Log
import java.net.InetAddress
import java.net.UnknownHostException

class NetworkCheckerImpl : NetworkChecker {
    override fun networkState(): Boolean {
        return Checking().execute().get()
    }

    class Checking : AsyncTask<Unit, Unit, Boolean>() {
        override fun doInBackground(vararg params: Unit?): Boolean {
            return try {
                val address = InetAddress.getByName("google.com")
                !address.equals("")
            } catch (e: UnknownHostException) {
                Log.wtf("internet", e.message)
                false
            }
        }


    }
}