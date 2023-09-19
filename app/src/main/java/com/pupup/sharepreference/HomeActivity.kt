package com.pupup.sharepreference

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)

        val getName = localStorage.getString("userName","Name Not found")
        val getEmail = localStorage.getString("userEmail","Email Not found")
        val showName : TextView = findViewById(R.id.showName)
        val showEmail : TextView = findViewById(R.id.showEmail)
        
        showName.text = getName
        showEmail.text=getEmail

        Toast.makeText(this, "${showName.text}", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "${showEmail.text}", Toast.LENGTH_SHORT).show()
    }
}