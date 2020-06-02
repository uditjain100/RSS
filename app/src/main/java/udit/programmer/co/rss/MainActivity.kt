package udit.programmer.co.rss

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import udit.programmer.co.rss.Adapter.FeedAdapter
import udit.programmer.co.rss.Common.HTTP_DataHandler
import udit.programmer.co.rss.Models.RSSObject
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val RSS_link = "https://rss.nytimes.com/services/xml/rss/nyt/Science.xml"
    private val RSS_to_JSON_API = " https://api.rss2json.com/v1/api.json?rss_url="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(toolbar_layout)
        toolbar_layout.title = "NEWS"
        rv_layout.apply {
            layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        }
        LoadRSS()
    }

    private fun LoadRSS() {
        val loadRSSAsync = object : AsyncTask<String, String, String>() {
            internal var mDialog = ProgressDialog(this@MainActivity)

            override fun doInBackground(vararg params: String): String {
                val result: String
                val http = HTTP_DataHandler()
                result = http.GetHttpDataHandler(params[0])
                return result
            }

            override fun onPostExecute(result: String?) {
                mDialog.dismiss()
                var rssObject: RSSObject
                rssObject = Gson().fromJson<RSSObject>(result, RSSObject::class.java)
                val adapter = FeedAdapter(rssObject, baseContext)
                rv_layout.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onPreExecute() {
                mDialog.setMessage("Please Wait ... ")
            }
        }

        val url_get_data = StringBuilder(RSS_to_JSON_API)
        url_get_data.append(RSS_link)
        loadRSSAsync.execute(url_get_data.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_refresh) LoadRSS()
        return true
    }
}
