package com.th.optimizer

object RootTools {
    fun run(cmd: String): Pair<String, Int> = try {
        val p = ProcessBuilder("su", "-c", cmd).redirectErrorStream(true).start()
        val out = p.inputStream.bufferedReader().readText()
        Pair(out.trim(), p.waitFor())
    } catch (e: Exception) { Pair(e.message ?: "erro", -1) }

    fun hasRoot(): Boolean = run("id").first.contains("uid=0")
}
