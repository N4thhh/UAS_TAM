package com.example.bangundit.ui.verify

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bangundit.databinding.ActivityVerifySucessBinding // 1. Import the generated binding class
import com.example.bangundit.ui.login.LoginActivity // Assuming LoginActivity is in this package

class VerifySucessActivity : AppCompatActivity() {

    // 2. Declare the binding variable
    private lateinit var binding: ActivityVerifySucessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. Inflate the layout using the binding object
        binding = ActivityVerifySucessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. Access the TextView through the binding object and set the listener
        binding.tvSignIn.setOnClickListener {
            // Create an intent to navigate to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            // Add flags to clear the activity stack so the user can't go back to the verification screen
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}