package br.com.faculdade.rubik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.cadastro_eletrica.*

class cadastroOleo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_oleo)
        setTitle("Novo Óleo")

        salvarDisciplina.setOnClickListener {
            val disciplina = Disciplina()
            disciplina.nome = nomeDisciplina.text.toString()
            disciplina.foto = urlFoto.text.toString()
            taskAtualizar(disciplina)
        }
    }

    private fun taskAtualizar(disciplina: Disciplina) {
        // Thread para salvar a disciplina
        Thread {
            DisciplinaService.saveOleo(disciplina)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

}