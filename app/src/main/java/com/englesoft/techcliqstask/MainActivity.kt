package com.englesoft.techcliqstask

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.englesoft.techcliqstask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val arr = arrayOf(
        arrayOf(0, 0), arrayOf(2, 0), arrayOf(1, 1), arrayOf(0, -1), arrayOf(-1, -1),
        arrayOf(0, 2), arrayOf(0, 1), arrayOf(1, 0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivIcon.setOnClickListener {
            binding.ivIcon.animate().rotation(180f).duration = 1000L
        }

        val res = ValidateSquare.checkSquare(arr)
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
    }
}