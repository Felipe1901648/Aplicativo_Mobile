package br.com.faculdade.rubik

import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_disciplina.*
import kotlinx.android.synthetic.main.toolbar.*

class DisciplinaActivity : DebugActivity() {
    var disciplina: Disciplina? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina)
    // recuperar onjeto de Disciplina da Intent
        disciplina = intent.getSerializableExtra("disciplina") as Disciplina
// configurar título com nome da Disciplina e botão de voltar da Toolbar
// colocar toolbar
        setSupportActionBar(toolbar)
// alterar título da ActionBar
        supportActionBar?.title = disciplina?.nome
// up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
// atualizar dados do carro
        nomeDisciplina.text = disciplina?.nome
        Picasso.with(this).load(disciplina?.foto).fit().into(imagemDisciplina,

            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}
                override fun onError() { }
            })

    }
}