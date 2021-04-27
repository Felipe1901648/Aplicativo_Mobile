package br.com.faculdade.rubik

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_eletrica.*
import kotlinx.android.synthetic.main.toolbar.*

class OleoActivity : AppCompatActivity() {
    private val context: Context get() = this
    private var disciplinas = listOf<Disciplina>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oleo)

        setSupportActionBar(toolbar)
        supportActionBar?.title="Óleos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerDisciplinas?.layoutManager = LinearLayoutManager(context)
        recyclerDisciplinas?.itemAnimator = DefaultItemAnimator()
        recyclerDisciplinas?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        // task para recuperar as disciplinas
        taskDisciplinas()
    }

    fun taskDisciplinas() {
        disciplinas = DisciplinaService.getDisciplinas(context)
        // atualizar lista
        recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas) {onClickDisciplina(it)}
    }

    fun onClickDisciplina(disciplina: Disciplina) {
        Toast.makeText(context, "Clicou disciplina ${disciplina.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, DisciplinaActivity::class.java)
        intent.putExtra("disciplina", disciplina)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_produtos, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id == R.id.action_sair) {
            val ok = Intent(this, MainActivity:: class.java)
            startActivity(ok)

        } else if (id == R.id.action_config) {
            val ok = Intent(this, ConfigActivity:: class.java)
            startActivity(ok)
        } else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}