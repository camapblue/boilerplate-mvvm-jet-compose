package ptc.tech.repository.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import org.json.JSONTokener
import ptc.tech.repository.global.DataAnalytics
import java.net.URL

open class BaseApi(
    private val analytics: DataAnalytics = DataAnalytics.instance
) {
    private fun execute(method: String, path: String, params: JSONObject? = null): JSONObject {
        // track api
        analytics.trackApi(path, "GET", params)
        try {
            val url = URL(path)
            val client = OkHttpClient()

            val body = params?.toString()?.toRequestBody()
            val request = Request.Builder()
                .method(method, body)
                .url(url)
                .build()

            val response = client.newCall(request).execute()
            val json = response.body?.string()

            return JSONTokener(json).nextValue() as JSONObject
        } catch (e: Exception) {
            // track api exception
            analytics.trackApiError(path, e)
            throw e
        }
    }

    fun get(path: String): JSONObject {
        return execute("GET", path)
    }

    fun post(path: String, params: JSONObject = JSONObject()): JSONObject {
        return execute("POST", path, params)
    }
}