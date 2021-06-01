package br.com.faculdade.rubik

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    val TAG = "RUBIK_FB"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)

        Log.d(TAG, "TOKEN_FB $token")
        Prefs.setString("TOKEN_FB", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        super.onMessageReceived(mensagemRemota)

        if(mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Titulo: $titulo")
            Log.d(TAG, "Corpo: $corpo")
        }
    }
}