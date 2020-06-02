package udit.programmer.co.rss.Common

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class HTTP_DataHandler() {
    var stream: String = ""
    fun GetHttpDataHandler(urlString: String): String {

        var url = URL(urlString)
        var urlConnection = url.openConnection() as HttpURLConnection

        if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
            var r =
                BufferedReader(InputStreamReader(BufferedInputStream(urlConnection.inputStream)))
            var sb = StringBuilder()
            var line = ""
            while ((line != r.readLine()) != null)
                sb.append(line)
            stream = sb.toString()
            urlConnection.disconnect()
        }
        return stream
    }


}