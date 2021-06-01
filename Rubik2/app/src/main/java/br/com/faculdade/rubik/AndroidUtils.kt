package br.com.faculdade.rubik

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object AndroidUtils {
    // verificar se existe algum tipo de conexão disponível
    fun isInternetDisponivel(): Boolean {
        val conexao = RubikApplication.get_instance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)  as ConnectivityManager

        val redes = conexao.allNetworks
        //Forçado
        return redes.map{conexao.getNetworkInfo(it)}.any{it!!.state == NetworkInfo.State.CONNECTED}
    }
}