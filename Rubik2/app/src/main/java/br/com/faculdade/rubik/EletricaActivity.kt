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

class EletricaActivity : AppCompatActivity() {
    private val context: Context get() = this
    private var disciplinas = listOf<Disciplina>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE= 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eletrica)

        setSupportActionBar(toolbar)
        supportActionBar?.title="Elétrica"
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
        Thread{
        this.disciplinas = DisciplinaService.getDisciplinas()
            runOnUiThread {
        // atualizar lista
        recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas) {onClickDisciplina(it)}
                val intent = Intent(this, DisciplinaActivity:: class.java)
                intent.putExtra("disciplina", disciplinas[0])
                NotificationUtil.create(1, intent, "LMSApp", "Produtos elétricos")
            }
        }.start()
    }

    fun onClickDisciplina(disciplina: Disciplina) {
        Toast.makeText(context, "Clicou no ${disciplina.nome}", Toast.LENGTH_SHORT).show()
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
        } else if (id == R.id.action_adicionar) {
            val intent = Intent(context, cadastroEletrica::class.java)
            startActivityForResult(intent, REQUEST_CADASTRO)
        } else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CADASTRO || requestCode == REQUEST_REMOVE) {
            // atualizar lista de disciplinas
            taskDisciplinas()
        }
    }
}