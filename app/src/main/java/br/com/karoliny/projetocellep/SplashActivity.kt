package br.com.karoliny.projetocellep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

//class SplashActivity : AppCompatActivity() {
    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_splash)

        //Handler().postDelayed({
           // startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
           // finish()
        //},5000)
   // }
//}


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Executar uma acão após determinado tempo

        Handler().postDelayed({

            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)

            // Remove a Activity

            finish()

        },3000)

    }

}
