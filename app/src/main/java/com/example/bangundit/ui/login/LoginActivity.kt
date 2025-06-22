package com.example.bangundit.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bangundit.MainActivity
import com.example.bangundit.databinding.ActivityLoginBinding // Import the generated binding class

class LoginActivity : AppCompatActivity() {

    // Declare the binding variable. This replaces all the individual view declarations.
    private lateinit var binding: ActivityLoginBinding
    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using ViewBinding. This is the modern, safe way.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the Volley request queue once
        requestQueue = Volley.newRequestQueue(this)

        // Access views via the binding object. It's type-safe and null-safe.
        binding.btnLogin.setOnClickListener {
            loginUser()
        }

        binding.btnGoogleSignIn.setOnClickListener {
            // TODO: Implement Google Sign-In logic here
            Toast.makeText(this, "Google Sign-In coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser() {
        // Get text from views using the binding object
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPasswordLogin.text.toString().trim()

        // --- Step 1: Input Validation ---
        if (email.isEmpty()) {
            binding.etEmail.error = "Email is required"
            binding.etEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Please enter a valid email"
            binding.etEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            binding.etPasswordLogin.error = "Password is required"
            binding.etPasswordLogin.requestFocus()
            return
        }

        // --- Step 2: Perform Network Request ---
        // The URL for the Android emulator to access the host machine's localhost
        val url = "http://10.0.2.2/BangunDIT/login.php"

        // Show a loading indicator (optional, but good practice)
        // binding.progressBar.visibility = View.VISIBLE

        val stringRequest = object : StringRequest(
            Method.POST, url,
            { response ->
                // Hide loading indicator
                // binding.progressBar.visibility = View.GONE

                // Trim the response to remove any potential whitespace from the server
                if (response.trim() == "success") {
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                    // Start MainActivity and finish LoginActivity so the user can't go back
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                // Hide loading indicator
                // binding.progressBar.visibility = View.GONE
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_LONG).show()
            }
        ) {
            // Override getParams to send email and password to the PHP script
            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["email"] = email
                params["password"] = password
                return params
            }
        }

        // Add the request to the queue to execute it
        requestQueue?.add(stringRequest)
    }
}