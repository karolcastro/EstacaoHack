import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.com.karoliny.projetocellep.MainActivity
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //Criando o spinner
        //Etapa 1: Criar a lista do spinner
        val listaSexo = arrayListOf("Selecione o sexo", "Feminino", "Masculino", "Outros")
        //listaSexo.add("Kaory")

        //Etapa 2: Criar o adapter do Spinner
        val spinnerAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        //Etapa 3: Linkar o adapter com o spinner
        spnSexo.adapter = spinnerAdapter

        //Clique do botão Cadastrar
        btnCadastrar.setOnClickListener {
            //Recuperar as informações digitadas pelo usuário
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenhaCadastro.text.toString().trim()
            val sexo = spnSexo.selectedItem.toString()

            //Verificar se os campos estão vazios
            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() ||
                sexo == "Selecione o sexo"){
                //Criando uma caixa de alerta
                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("Atenção")
                    .setMessage("Preencha todos os campos!")
                    .setPositiveButton("OK"){_, _ ->
                        //Função Lambda
                    }
                    .setCancelable(false)
                    .create()
                    .show()

            }else{
                //Gravar os dados do usuário no Shared Preferences
                getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE).edit().apply{
                    putString("nome", nome)
                    putString("sobrenome", sobrenome)
                    putString("email", email)
                    putString("senha", senha)
                    putString("sexo", sexo)
                }.apply()

                //Criando uma mensagem de sucesso ao usuário
                Toast.makeText(this@CadastroActivity, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()

                //Limpando todos os campos
                edtNome.setText("")
                edtSobrenome.text.clear()
                edtEmail.text.clear()
                edtSenhaCadastro.text.clear()
                //Voltar o spinner para a configuração inicial
                spnSexo.setSelection(0)

                // abrir a tela Main
                startActivity(Intent(this@CadastroActivity, MainActivity::class.java).apply {
                    //Passagem de parametro de uma tela para a outra
                    putExtra("email", email)
                })
                //Tirar  todas as telas anteriores  do empilhamento
                finishAffinity()
            }
        }
    }
}