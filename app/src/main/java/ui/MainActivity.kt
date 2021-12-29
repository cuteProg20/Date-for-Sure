package ui

import android.content.Intent
import android.util.Patterns
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dateforsure.R
import com.example.dateforsure.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usernameFocusChanger()
        passwordFocusListener()

        binding.buttonlogin.setOnClickListener { submitForm() }

    }

    private fun submitForm() {

        binding.usernamecontainer.helperText = validateUsername()
        binding.passwordcontainer.helperText = validPassword()


        val validEmail = binding.usernamecontainer.helperText == null
        val validPassword = binding.passwordcontainer.helperText == null

        if (validEmail && validPassword )
            resetForm()
        else
            invalidForm()

    }

    private fun invalidForm() {
        var message = ""
        if(binding.usernamecontainer.helperText != null)
            message += "\n\nEmail: " + binding.usernamecontainer.helperText
        if(binding.passwordcontainer.helperText != null)
            message += "\n\nPassword: " + binding.passwordcontainer.helperText


        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                // do nothing
            }
            .show()
    }


    private fun resetForm() {
        var message = "Email: " + binding.username.text
        message += "\nPassword: " + binding.Passwordlogin.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Ok"){ _,_ ->
                binding.username.text = null
                binding.Passwordlogin.text = null

                val intent = Intent(this, MainScreen::class.java)
                      startActivity(intent)

                binding.usernamecontainer.helperText = getString(R.string.required)
                binding.passwordcontainer.helperText = getString(R.string.required)

            }
            .show()
    }

    private fun usernameFocusChanger(){
        binding.username.setOnFocusChangeListener{_, focused ->
            if (!focused){
                binding.usernamecontainer.helperText = validateUsername()
            }
        }
    }

private  fun validateUsername() : String?{

    val username = binding.username.text.toString()

    if (!Patterns.EMAIL_ADDRESS.matcher(username).matches())
    {
        return "invalide username"
    }

    return null
}

    private fun passwordFocusListener()
    {
        binding.Passwordlogin.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.passwordcontainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {

        val passwordText = binding.Passwordlogin.text.toString()
        if(passwordText.length < 8)
        {
            return "Minimum 8 Character Password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }

        return null

    }




    fun gotoSign(v: View) {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }

//    fun gotoHome(v: View) {
//        val intent = Intent(this, MainScreen::class.java)
//        startActivity(intent)
//    }
}