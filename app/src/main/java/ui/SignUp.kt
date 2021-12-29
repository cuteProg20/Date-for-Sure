package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.dateforsure.R
import com.example.dateforsure.databinding.SignUpBinding


class SignUp : AppCompatActivity() {

    private lateinit var binding : SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usernameFocusChanger()
        emailFocusChanger()
        passwordFocusChanger()

        binding.buttonSignup.setOnClickListener { submitForm() }
    }

    private fun passwordFocusChanger() {
        binding.userpassword.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.userpasswordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {

        val passwordText = binding.userpassword.text.toString()
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



    private fun submitForm() {
        binding.usernameContainer.helperText = validateUsername()
        binding.useremailContainer.helperText = validateUseremail()
        binding.userpasswordContainer.helperText = validPassword()



        val validEmail = binding.usernameContainer.helperText == null
        val validPassword = binding.userpasswordContainer.helperText == null

        if (validEmail && validPassword )
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm() {
        var message = ""
        if(binding.usernameContainer.helperText != null)
            message += "\n\nEmail: " + binding.usernameContainer.helperText
        if(binding.userpasswordContainer.helperText != null)
            message += "\n\nPassword: " + binding.userpasswordContainer.helperText


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
        message += "\nPassword: " + binding.userpassword.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                binding.username.text = null
                binding.userpassword.text = null


                binding.usernameContainer.helperText = getString(R.string.required)
                binding.userpasswordContainer.helperText = getString(R.string.required)

            }
            .show()
    }

    private fun usernameFocusChanger(){
        binding.username.setOnFocusChangeListener{_, focused ->
            if (!focused){
                binding.usernameContainer.helperText = validateUsername()
            }
        }
    }

    private  fun validateUsername() : String?{

        val usernameText = binding.username.text.toString()
        if(usernameText.length < 8)
        {
            return "Minimum 8 Character Password"
        }
        if(!usernameText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!usernameText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!usernameText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }

        return null

    }


    private fun emailFocusChanger(){
        binding.userEmail.setOnFocusChangeListener{_, focused ->
            if (!focused){
                binding.useremailContainer.helperText = validateUseremail()
            }
        }
    }

    private  fun validateUseremail() : String?{

        val username = binding.userEmail.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches())
        {
            return "invalide Email"
        }

        return null
    }


    fun goToVerification(v: View){
        val intent = Intent(this, VerificationActivity::class.java)
        startActivity(intent)
    }

}
