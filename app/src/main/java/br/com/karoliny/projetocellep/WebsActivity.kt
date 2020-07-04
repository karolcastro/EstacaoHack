    package br.com.karoliny.projetocellep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webs.*

    class WebsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webs)

        wbvSite.settings.javaScriptEnabled = true
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")
        wbvSite.webViewClient = webViewClient()
    }
}