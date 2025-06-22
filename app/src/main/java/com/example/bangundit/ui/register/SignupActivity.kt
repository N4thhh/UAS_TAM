package com.example.bangundit.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Log // Import Log for debugging
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bangundit.MainActivity // Import your MainActivity
import com.example.bangundit.databinding.ActivitySignupBinding
import com.example.bangundit.ui.login.LoginActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestQueue = Volley.newRequestQueue(this)

        binding.btnSignUp.setOnClickListener {
            registerUser()
        }

        binding.tvSignIn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnGoogleSignUp.setOnClickListener {
            Toast.makeText(this, "Google Sign-Up coming soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registerUser() {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        // Client-side validation
        if (name.isEmpty()) {
            binding.etName.error = "Name is required"
            binding.etName.requestFocus()
            return
        }
        // ... (other validations for email and password remain the same) ...
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
            binding.etPassword.error = "Password is required"
            binding.etPassword.requestFocus()
            return
        }


        val url = "http://10.0.2.2/BangunDIT/register.php"

        val stringRequest = object : StringRequest(
            Method.POST, url,
            { response ->
                Log.d("SignupActivity_Response", "Raw Response: ['$response']")
                val trimmedResponse = response.trim()
                Log.d("SignupActivity_Response", "Trimmed Response: ['$trimmedResponse']")

                // Make sure to compare case-insensitively
                if (trimmedResponse.equals("success", ignoreCase = true)) {
                    // Toast.makeText(this, "Registration successful! Please log in.", Toast.LENGTH_LONG).show() // Old toast
                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show() // New toast

                    // --- START OF CHANGES ---
                    // Go to MainActivity (which should then show HomeFragment)
                    val intent = Intent(this@SignupActivity, MainActivity::class.java)

                    // Optional: Clear the back stack so the user can't navigate back
                    // to the signup/splash screen from the main app.
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                    finish() // Close SignupActivity so it's removed from the back stack
                    // --- END OF CHANGES ---

                } else {
                    // Show the actual response from PHP for better debugging
                    Toast.makeText(this, "Registration failed: $response", Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                // Log the error for better debugging
                Log.e("SignupActivity_Error", "Volley Error: ${error.message}", error)
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["name"] = name
                params["email"] = email
                params["password"] = password
                return params
            }
        }
        requestQueue?.add(stringRequest)
    }
}