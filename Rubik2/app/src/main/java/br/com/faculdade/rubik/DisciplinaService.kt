package br.com.faculdade.rubik

import android.content.Context
import android.nfc.Tag
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Response
import java.net.URL

object DisciplinaService {

    val host = "https://felipegears.pythonanywhere.com"
    val TAG = "WS_LMSAPP"



    fun getDisciplinas (): List<Disciplina> {

        if(AndroidUtils.isInternetDisponivel()) {
            val url = "$host/disciplinas"
            val json = HttpHelper.get(url)
            var disciplinas = parserJson<ArrayList<Disciplina>>(json)

            for (d in disciplinas) {
                saveOffline(d)
            }; return disciplinas
        } else {
            val dao = DatabaseManager.getDisciplinaDAO()
            val disciplinas = dao.findAll()
            return disciplinas
        }
    }

    fun saveOffline(disciplina: Disciplina) : Boolean {
        val dao = DatabaseManager.getDisciplinaDAO()
        if (! existeDisciplina(disciplina)) {
            dao.insert(disciplina)
        }
        return true
    }

    fun existeDisciplina(disciplina: Disciplina): Boolean {
        val dao = DatabaseManager.getDisciplinaDAO()
        //Forçado
        return dao.getById(disciplina.id!!) != null

    }

    fun saveDisciplina(disciplina: Disciplina){

        val json = disciplina.toJson()
        HttpHelper.post("$host/disciplinas", json)

    }

    fun getOleo (): List<Disciplina> {

        if(AndroidUtils.isInternetDisponivel()) {
        val url = "$host/oleo"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var oleo = parserJson<ArrayList<Disciplina>>(json)

            for (d in oleo) {
                saveOffline(d)
            }; return oleo
        } else {
            val dao = DatabaseManager.getDisciplinaDAO()
            val disciplinas = dao.findAll()
            return disciplinas
        }
    }

    fun saveOleo(disciplina: Disciplina){

        val json = disciplina.toJson()
        HttpHelper.post("$host/oleo", json)

    }

    fun getPneu (): List<Disciplina> {

        if(AndroidUtils.isInternetDisponivel()) {
        val url = "$host/pneu"
        val json= HttpHelper.get(url)

        Log.d(TAG, json)
        var pneu = parserJson<ArrayList<Disciplina>>(json)

            for (d in pneu) {
                saveOffline(d)
            }; return pneu
        } else {
            val dao = DatabaseManager.getDisciplinaDAO()
            val disciplinas = dao.findAll()
            return disciplinas
        }
    }

    fun savePneu(disciplina: Disciplina){

        val json = disciplina.toJson()
        HttpHelper.post("$host/pneu", json)

    }

    fun delete(disciplina: Disciplina): Response {
        val url = "$host/disciplinas/${disciplina.id}"
        val json = HttpHelper.delete(url)
        return parserJson<Response>(json)
    }

    fun deleteOleo(disciplina: Disciplina): Response {
        val url = "$host/oleo/${disciplina.id}"
        val json = HttpHelper.delete(url)
        return parserJson<Response>(json)
    }

    fun deletePneu(disciplina: Disciplina): Response {
        val url = "$host/pneu/${disciplina.id}"
        val json = HttpHelper.delete(url)
        return parserJson<Response>(json)
    }


    inline fun<reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}