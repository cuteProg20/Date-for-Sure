package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dateforsure.R

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

    }

    fun goToVerification(v: View){
        val intent = Intent(this, VerificationActivity::class.java)
        startActivity(intent)
    }

}