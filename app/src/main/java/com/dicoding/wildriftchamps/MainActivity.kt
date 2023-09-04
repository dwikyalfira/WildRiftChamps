package com.dicoding.wildriftchamps

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvChampion: RecyclerView
    private val list = ArrayList<Champion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "WR Champs"


        rvChampion = findViewById(R.id.rv_champions)
        rvChampion.setHasFixedSize(true)

        list.addAll(getListChampion())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvChampion.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvChampion.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun getListChampion(): ArrayList<Champion> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataRegion = resources.getStringArray(R.array.data_region)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhotoIcon = resources.obtainTypedArray(R.array.data_photo_icon)
        val dataPhotoBG = resources.obtainTypedArray(R.array.data_photo_bg)
        val listChampion = ArrayList<Champion>()
        for (i in dataName.indices) {
            val champion = Champion(dataName[i], dataRole[i], dataRegion[i], dataDescription[i], dataPhotoIcon.getResourceId(i, -1),dataPhotoBG.getResourceId(i, -1))
            listChampion.add(champion)
        }
        return listChampion
    }

    private fun showRecyclerList() {
        rvChampion.layoutManager = LinearLayoutManager(this)
        val listChampionAdapter = ListChampionAdapter(list)
        rvChampion.adapter = listChampionAdapter
    }


}