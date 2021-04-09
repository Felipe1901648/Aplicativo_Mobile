package br.com.faculdade.rubik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.SearchEvent
import android.view.ViewConfiguration
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class activityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.title="Produtos"

        eletrica_botao.setOnClickListener {
            val ok = Intent(this, EletricaActivity:: class.java)
            startActivity(ok)
        }

        oleo_botao.setOnClickListener {
            val ok = Intent(this, OleoActivity:: class.java)
            startActivity(ok)
        }
        pneu_botao.setOnClickListener {
            val ok = Intent(this, PneuActivity:: class.java)
            startActivity(ok)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(this@activityMenu,"$newText",Toast.LENGTH_LONG).show()
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@activityMenu,"$query",Toast.LENGTH_LONG).show()
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id == R.id.action_sair) {
            finish()

        } else if (id == R.id.action_config) {
            val ok = Intent(this, ConfigActivity:: class.java)
            startActivity(ok)
        }
        return super.onOptionsItemSelected(item)
    }

}