package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.example.dateforsure.databinding.SignUpBinding


class SignUp : AppCompatActivity() {

    private lateinit var binding : SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usernameFocusChanger()
        EmailFocusChanger()

    }

    fun usernameFocusChanger(){
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


    fun EmailFocusChanger(){
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
