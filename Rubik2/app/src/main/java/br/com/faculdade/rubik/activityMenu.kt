package br.com.faculdade.rubik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.*
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class activityMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
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
        configuraMenuLateral()
    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
                this,
                layoutMenuLateral,
                R.string.drawer_open,
                R.string.drawer_close)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_pneu -> {
                val ok = Intent(this, PneuActivity:: class.java)
                startActivity(ok)
            }
            R.id.nav_oleo -> {
                val ok = Intent(this, OleoActivity:: class.java)
                startActivity(ok)
            }
            R.id.nav_eletrica -> {
                val ok = Intent(this, EletricaActivity:: class.java)
                startActivity(ok)
            }
            R.id.nav_sair -> {
                val ok = Intent(this, MainActivity:: class.java)
                startActivity(ok)
            }
        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
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