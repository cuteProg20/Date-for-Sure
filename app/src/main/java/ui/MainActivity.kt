package ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dateforsure.R
import com.example.dateforsure.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        


    }


    fun gotoSign(v: View) {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }

    fun gotoHome(v: View) {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
}