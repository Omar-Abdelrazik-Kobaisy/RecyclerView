package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.recyclerviewkotlin.databinding.ActivityDetailsBinding
import com.example.recyclerviewkotlin.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.callPic.setImageResource(intent.getIntExtra("img",-1))
        binding.nameTv.text = intent.getStringExtra("name")
    }
}