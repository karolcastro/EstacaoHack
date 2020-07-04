package br.com.karoliny.projetocellep

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar o e-mail da intent
        val emailRecuperado = intent.getStringExtra("email")

        //Abrindo  o Shared Preference
        val minhaPreferencia = getSharedPreferences("cadastro-$emailRecuperado", Context.MODE_PRIVATE)

        //Recuoperando os dados do Shared Preference e substituindo no TextView correspondente

        val nome = minhaPreferencia.getString("nome", "Chave não encontrada")
        val sobrenome = minhaPreferencia.getString("sobrenome", "Chave não encontrada")

        txvNomeCompleto.text = "$nome $sobrenome"
        txvEmail.text = minhaPreferencia.getString("email", "Chave não encontrada")
        txvSexo.text = minhaPreferencia.getString("sexo", "Chave não encontrada")

        // Clique do botao sair
        btnSair.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Atenção")
                .setMessage("Você deseja sair mesmo ?")
                .setPositiveButton("Sim") { _, _ ->
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Não") {_, _ ->
                }
                .setCancelable(false)
                .create()
                .show()
        }

        // clique do botao Site Cellep
        btnSite.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebsActivity::class.java))
            finish()
        }
    }
}