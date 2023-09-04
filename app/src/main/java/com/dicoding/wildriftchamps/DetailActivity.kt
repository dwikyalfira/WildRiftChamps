package com.dicoding.wildriftchamps

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.wildriftchamps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    private lateinit var champion: Champion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val champion = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_champion", Champion::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_champion")
        }

        if (champion != null) {
            Log.e("Test",champion.toString())
            binding.apply {
                championName.text = champion.name
                championRole.text = champion.role
                championRegion.text = champion.region
                championDescription.text = champion.description
                championIcon.setImageResource(champion.photoIcon)
                championBg.setImageResource(champion.photoBG)
                actionShare.setOnClickListener{
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    var text = "Name: ${champion.name}\n" +
                            "${champion.role}\n" +
                            "${champion.region}"
                    intent.putExtra(Intent.EXTRA_TEXT, text)
                    startActivity(Intent.createChooser(intent,null))
                }
            }
        }
        val actionbar = supportActionBar
        actionbar!!.title = "${champion?.name}"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

