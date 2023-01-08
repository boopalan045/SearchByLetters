package com.asustug.dictionaryapp.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.asustug.dictionaryapp.R
import com.asustug.dictionaryapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    var i: Int = 0

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    private fun createNewButton() {
        val btnClick: Button = findViewById(R.id.button)

        btnClick.setOnClickListener {
            i++
            Toast.makeText(applicationContext, "clicked $i times", Toast.LENGTH_SHORT).show()
        }
    }

    fun createAsyncTask() {
        createNewButton()
        //alternate way for creating AsyncTask
        Thread {
            runOnUiThread(Runnable { })
        }

        val arrayList = arrayListOf<String>("1", "2", "3")
        arrayList.add("hello")
        arrayList.remove("1")
        for (i in arrayList) {
            Log.d("TAG", "createAsyncTask: " + i)
        }

        val picasso = Picasso.get()
        val url = ""
        /*val imageView = findViewById<ImageView>(R.id.imageView)
        picasso.load(R.drawable.ic_launcher_foreground).into(imageView)*/

        val array = Arrays.asList(1, 2, 3)
        val newArr = Arrays.asList(0, *array.toTypedArray(), 4)

        val peopleAge = mutableMapOf<String, Int>(
            "Manoj" to 25,
            "Boopalan" to 27
        )
        peopleAge.remove("Manoj")
        peopleAge.put("newlyAdd", 0)
        val filteredNames = peopleAge.filter { it.key.length < 10 }

        val words = listOf(
            "about",
            "acute",
            "awesome",
            "balloon",
            "best",
            "brief",
            "class",
            "coffee",
            "creative"
        )
        val newFilter = words.filter {
            it.startsWith("a", ignoreCase = true)
        }
            .shuffled()
            .take(2)
        Log.d("TAG --> ", "createAsyncTask: " + newFilter)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}