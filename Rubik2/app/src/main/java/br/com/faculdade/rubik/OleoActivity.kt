package br.com.faculdade.rubik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*

class OleoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oleo)

        setSupportActionBar(toolbar)
        supportActionBar?.title="Óleos"
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
        }
        return super.onOptionsItemSelected(item)
    }
}