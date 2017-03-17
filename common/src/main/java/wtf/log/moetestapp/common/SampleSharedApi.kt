package wtf.log.moetestapp.common

import okhttp3.OkHttpClient
import okhttp3.Request

object SampleSharedApi {

  private val httpClient = OkHttpClient.Builder().build()

  @JvmStatic fun fetchImage(): ByteArray {
    val request = Request.Builder()
        .get()
        .url("http://i.ytimg.com/vi/cNycdfFEgBc/maxresdefault.jpg")
        .build()
    val response = httpClient.newCall(request).execute()
    return response.body().bytes()
  }

}
