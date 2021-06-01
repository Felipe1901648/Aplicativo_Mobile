package br.com.faculdade.rubik

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_disciplina.*
import kotlinx.android.synthetic.main.toolbar.*

class DisciplinaActivity : DebugActivity() {
    var disciplina: Disciplina? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.main_menu_disciplina, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado
        // remover a disciplina no WS
        if (id == R.id.action_remover) {
            // alerta para confirmar a remoção
            // só remove se houver confirmação positiva
            AlertDialog.Builder(this)

                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir o produto Elétrico ?")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluir()

                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()

        } else if (id == R.id.action_remover_oleo) {
            // alerta para confirmar a remoção
            // só remove se houver confirmação positiva
            AlertDialog.Builder(this)

                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir o Óleo ?")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluirOleo()

                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()

        } else if (id == R.id.action_remover_pneu) {
            // alerta para confirmar a remoção
            // só remove se houver confirmação positiva
            AlertDialog.Builder(this)

                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir o Pneu ?")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluirPneu()

                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()

        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun taskExcluir() {
        if (this.disciplina != null && this.disciplina is Disciplina) {
            // Thread para remover a disciplina
            Thread {
                DisciplinaService.delete(this.disciplina as Disciplina)
                runOnUiThread {
            // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }

    private fun taskExcluirPneu() {
        if (this.disciplina != null && this.disciplina is Disciplina) {
            // Thread para remover a disciplina
            Thread {
                DisciplinaService.deletePneu(this.disciplina as Disciplina)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }

    private fun taskExcluirOleo() {
        if (this.disciplina != null && this.disciplina is Disciplina) {
            // Thread para remover a disciplina
            Thread {
                DisciplinaService.deleteOleo(this.disciplina as Disciplina)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }

}