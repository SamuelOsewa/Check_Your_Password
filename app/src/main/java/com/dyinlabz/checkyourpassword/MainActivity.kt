package com.dyinlabz.checkyourpassword

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextPassword: EditText = findViewById(R.id.EditTextPassword)
        val checkButton: Button = findViewById(R.id.CheckButton)
        val textViewResult: TextView = findViewById(R.id.TextViewResult)

        //This line assigns to value of view.invisible to the variable textViewResult.visibility
        textViewResult.visibility = View.INVISIBLE

        fun capsCheck(password: String): Boolean{
            //This for loop iterates through the string and checks if any of the characters of the
            // string is uppercase then it returns either true or false
            for (char in password){
                return char.isUpperCase()
            }
            return false
        }

        // This function is supposed to be used to check if the password has a number in it but
        // it isn't wprking as it should so I'm hoping for support
       /** fun numCheck(password: String): Boolean{
            for (char in password){
                return char.isDigit()
            }
            return true
        } **/

        fun checkPassword(password: String): String{
            val message: String
            if (password.length > 10 && capsCheck(password)){
                message = "Password is Okay"
            } else {
                message = "Your password could be cracked by a 9 yr old. Make it harder"
            }
            return message
        }

        checkButton.setOnClickListener {
            val password = editTextPassword.text.toString().trim()
            val passwordCheck =  checkPassword(password)
            textViewResult.visibility = View.VISIBLE
            textViewResult.text = passwordCheck

        }


    }
}