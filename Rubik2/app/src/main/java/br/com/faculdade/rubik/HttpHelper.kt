package br.com.faculdade.rubik

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

object HttpHelper {

    var client = OkHttpClient()

    private fun getJson(request: Request): String {
        val response = client.newCall(request).execute()
        val body = response.body()
        if (body != null) {
            return body.string()
        }
        throw IOException("Erro na Requisição")
    }

    fun get(url: String): String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    val JSON = MediaType.parse("application/json; charset=utf-8")

    fun post(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    fun delete(url: String): String {
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }
}