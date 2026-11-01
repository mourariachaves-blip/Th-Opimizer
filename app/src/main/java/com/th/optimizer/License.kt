package com.th.optimizer

import android.content.Context
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Locale

// Licença interna: lida de assets/license.json e nunca exibida na tela.
object License {
    fun valid(ctx: Context): Boolean = try {
        val j = JSONObject(ctx.assets.open("license.json").bufferedReader().use { it.readText() })
        if (j.optString("app") != "TH OPTIMIZE") false else {
            val arr = j.getJSONArray("licenses")
            (0 until arr.length()).any { i ->
                val l = arr.getJSONObject(i)
                l.optBoolean("active", false) && l.optString("key").isNotBlank() && notExpired(l)
            }
        }
    } catch (e: Exception) { false }

    private fun notExpired(l: JSONObject): Boolean {
        if (l.isNull("expires")) return true
        val d = try { SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(l.getString("expires")) } catch (e: Exception) { null }
        return d != null && d.time >= System.currentTimeMillis()
    }
}
