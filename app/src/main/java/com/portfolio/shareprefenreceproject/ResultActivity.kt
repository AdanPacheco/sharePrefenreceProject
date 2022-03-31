package com.portfolio.shareprefenreceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.portfolio.shareprefenreceproject.databinding.ActivityResultBinding
import com.portfolio.shareprefenreceproject.SharedPreferenceApplication.Companion.prefs

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        InitUI()
    }

    private fun InitUI() {
        binding.btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        val userName = prefs.getName()
        binding.tvName.text = "Bienvenido ${userName}"
        if (prefs.getVIP()) {
            setVIPColorBackground()
        }
    }

    private fun setVIPColorBackground() {
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
    }
}