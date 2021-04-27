package br.com.faculdade.rubik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {
    private val TAG = "Rubik"
    private val className:String
        get(){
            val c = javaClass.name //br.com.faculdade.Imsapp(debugactivity)
            return c.substring(c.lastIndexOf("."))

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className.onCreate() chamando")
    }
    override  fun onStart(){
        super.onStart()
        Log.d(TAG, "$className.onStart() chamando")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$className.onRestart() chamando")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className.onResume() chamando")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$className.onPause() chamando")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className.onStop() chamando")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className.onDestroy() chamando")
    }
}