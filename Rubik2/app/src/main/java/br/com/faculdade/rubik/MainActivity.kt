package br.com.faculdade.rubik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        supportActionBar?.title="Rubik"

        imagem_inicial.setImageResource(R.drawable.mecanica)
        botaoLogin.setOnClickListener {
            val login = campoUsuario.text.toString()
            val senha = campoSenha.text.toString()
            if(login.equals("aluno") && senha.equals("impacta")) {
                val telamain = Intent(this, activityMenu:: class.java)
                startActivity(telamain)
            }
            else{
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()

            }
        }
    }
}