package com.example.parcial_pdm
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_pdm.adapter.partido_adapter
import com.example.parcial_pdm.entities.partido
import com.example.parcial_pdm.viewModel.Partido_viewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), fragment_principal.OnListener  {

    private lateinit var partidoViewModel : Partido_viewModel
    private lateinit var adapterPartido : partido_adapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (fab != null){
            fab.setOnClickListener { view ->
                var intent = Intent(this, PartidoActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun mostrarPartido(partido: partido){
        var intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("Info", partido as Parcelable)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

