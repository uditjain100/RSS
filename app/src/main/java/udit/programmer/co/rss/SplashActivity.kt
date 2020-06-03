package udit.programmer.co.rss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        val splash_screen = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        splash_screen.start()
    }
}