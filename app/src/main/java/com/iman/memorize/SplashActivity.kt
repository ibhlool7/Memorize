package com.iman.memorize

import android.app.Activity
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import java.net.InetAddress
import java.net.UnknownHostException

class SplashActivity : AppCompatActivity() {

    private val activity: Activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val execute = NetworkChecking().execute().get()
        Log.i("result", execute.toString())

        logo.visibility = View.INVISIBLE
        animate()
    }

    private fun animate() {
        val animation = AnimationUtils.loadAnimation(activity, R.anim.fall)
        top.startAnimation(animation)
        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                logo.visibility = View.VISIBLE
                val drawable: Drawable = logo.drawable
                if (drawable is Animatable) {
                    drawable.start()
                }
            }
        }.start()
    }
    /*
    This class  checking the 'google.com' address , if the site makes response the Internet connection is exists otherwise
    the connection is intercept !!!
     */

    class NetworkChecking : AsyncTask<Unit, Unit, Boolean>() {
        override fun onPreExecute() {
            super.onPreExecute()
            Log.wtf("do ASYNC", "DOING")
        }

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
