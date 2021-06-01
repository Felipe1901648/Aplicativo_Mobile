package br.com.faculdade.rubik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_eletrica.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        supportActionBar?.title = "Rubik"

        imagem_inicial.setImageResource(R.drawable.mecanica)
        campoUsuario.setText(Prefs.getString("nome_usuario"))
        campoSenha.setText(Prefs.getString("senha"))
        campo_checkBox.isChecked = Prefs.getBoolean("check")

        botaoLogin.setOnClickListener {
            val login = campoUsuario.text.toString()
            val senha = campoSenha.text.toString()
            val checkbox = campo_checkBox.isChecked
            if (login.equals("aluno") && senha.equals("impacta")) {
                val telamain = Intent(this, activityMenu::class.java)
                startActivity(telamain)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
            if (checkbox) {
                Prefs.setString("nome_usuario", login)
                Prefs.setString("senha", senha)
                Prefs.setBoolean("check", checkbox)
            } else {
                Prefs.setString("nome_usuario", "")
                Prefs.setString("senha", "")
                Prefs.setBoolean("check", false)
            }
        }
    }
}