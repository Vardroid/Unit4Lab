package com.example.unit4lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.loginBtn).setOnClickListener{login()}
    }

    private fun login() {
        val username = findViewById<EditText>(R.id.usernameTxt).text.toString()
        val password = findViewById<EditText>(R.id.passwordTxt).text.toString()
        if ((username == "hello").and(password == "hello")) {
            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Wrong Login Information.", Toast.LENGTH_LONG).show()
        }
    }
}