package com.portfolio.shareprefenreceproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.portfolio.shareprefenreceproject.databinding.ActivityMainBinding
import com.portfolio.shareprefenreceproject.SharedPreferenceApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        InitUI()
        CheckUserData()
    }

    private fun CheckUserData() {
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }


    private fun InitUI(){
        binding.button.setOnClickListener{
            accesToDetail()
        }
    }

    private fun accesToDetail() {
        if(binding.etName.text.toString().isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVIP(binding.checkBox.isChecked)
            goToDetail()
        }else{
            Toast.makeText(this,"El nombre no puede estar vacio",Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToDetail() {
        startActivity(Intent(this,ResultActivity::class.java))
    }
}