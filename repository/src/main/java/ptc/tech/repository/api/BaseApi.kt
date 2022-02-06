package ptc.tech.repository.api

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL

open class BaseApi {
    fun get(path: String): JSONObject {
        val url = URL(path)
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        val json = response.body?.string()

        return JSONTokener(json).nextValue() as JSONObject
    }
}