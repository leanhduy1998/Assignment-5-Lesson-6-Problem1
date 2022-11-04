package com.example.assignment_5_lesson_6_problem1

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import com.example.assignment_5_lesson_6_problem1.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstQuestion = findViewById<RadioGroup>(R.id.q1RadioGroup)
        val secondQuestion = findViewById<RadioGroup>(R.id.q2RadioGroup)

        findViewById<Button>(R.id.submitButton).setOnClickListener {
                val simpleDate = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = simpleDate.format(Date())
                var score = 0
                if (firstQuestion.checkedRadioButtonId == R.id.correctQ1) {
                    score += 50
                }
                if (secondQuestion.checkedRadioButtonId == R.id.correctQ2) {
                    score += 50
                }
                Toast.makeText(baseContext, "Submitted on " + currentDate + ", You achieved " + score + "%", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.resetButton).setOnClickListener {
            firstQuestion.clearCheck()
            secondQuestion.clearCheck()
        }
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

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}