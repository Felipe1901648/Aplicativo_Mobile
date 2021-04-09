package br.com.faculdade.rubik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DebugActivity : AppCompatActivity() {

    private val TAG = "rubik"
    private val className: String
    get() {
        val nomeDaClasse = javaClass.name // br.com.faculdade.rubik
        return nomeDaClasse.substring(nomeDaClasse.lastIndexOf("."))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className.onCreate() chamando")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className.onstart() Chamando")
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