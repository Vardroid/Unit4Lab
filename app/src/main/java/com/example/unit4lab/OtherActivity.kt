package com.example.unit4lab

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        findViewById<Button>(R.id.createMsgbtn).setOnClickListener{createMessage()}
        findViewById<Button>(R.id.openYouTubeBtn).setOnClickListener{openYT()}
        findViewById<Button>(R.id.openSettingsBtn).setOnClickListener{openSett()}
        findViewById<Button>(R.id.openInputBtn).setOnClickListener{openInp()}
        findViewById<Button>(R.id.imgEditBtn).setOnClickListener{biom()}
    }

    private fun createMessage(){
        // Create the text message with a string
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hi hi")
            type = "text/plain"
        }

        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
    }

    private fun openYT(){
        val webpage: Uri = Uri.parse("https://m.youtube.com")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openSett(){
        val intent = Intent(Settings.ACTION_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun openInp(){
        val intent = Intent(Intent.ACTION_ANSWER)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            //There is no call to be answered
            Toast.makeText(this, "No Call to be Answered", Toast.LENGTH_LONG).show()
        }
    }
    private fun biom(){
        val intent = Intent(Settings.ACTION_BIOMETRIC_ENROLL)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            //This intent action is only available for API level 30
            Toast.makeText(this, "No setting available", Toast.LENGTH_LONG).show()
        }
    }
}