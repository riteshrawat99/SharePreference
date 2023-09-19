package com.pupup.sharepreference

import android.content.Context
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
        
        val viewName : EditText = findViewById(R.id.nameView)    
        val viewEmail : EditText = findViewById(R.id.emailView)
        val save : Button = findViewById(R.id.sbumit)
        val show : Button = findViewById(R.id.show)
        
        val localStorage = getSharedPreferences("user",Context.MODE_PRIVATE)

        save.setOnClickListener {
            val editPref = localStorage.edit()
            editPref.putString("userName", viewName.text.toString())
            editPref.putString("userEmail",viewEmail.text.toString()).apply()
        }
        
        show.setOnClickListener { 
            val getName = localStorage.getString("userName","Name Not found")
            val getEmail = localStorage.getString("userEmail","Email Not found")

            Toast.makeText(this, "$getEmail , $getName", Toast.LENGTH_SHORT).show()

            if (viewName.text.isEmpty()){
                viewName.error = "Enter your name"
            }
            else if(viewEmail.text.isEmpty()){
                viewEmail.error = "Enter your email"
            }
            else{
            val intent = Intent(this,HomeActivity::class.java)
//            intent.putExtra("name",getName)
//            intent.putExtra("email",getEmail)
                startActivity(intent)
            }
        }
    }
}