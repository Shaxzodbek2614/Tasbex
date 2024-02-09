package com.example.tasbex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasbex.databinding.ActivityMainBinding
import com.example.tasbex.utils.MySharedPreference

@Suppress("UNUSED_CHANGED_VALUE")
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        binding.txt.text = MySharedPreference.myCounter.toString()
        binding.sana.text = MySharedPreference.sanoq.toString()

        binding.card.setOnClickListener {
            var count = MySharedPreference.myCounter
            count++
            binding.txt.text = count.toString()
            MySharedPreference.myCounter = count
            if (count%33==0){
                val sana = count/33
                binding.sana.text = sana.toString()
                MySharedPreference.sanoq = sana
            }
        }

        binding.clear.setOnClickListener {
            MySharedPreference.myCounter = 0
            binding.txt.text = "0"
            MySharedPreference.sanoq = 0
            binding.txt.text = "0"
            binding.sana.text = "0"
        }
    }
}