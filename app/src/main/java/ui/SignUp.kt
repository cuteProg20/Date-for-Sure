package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.dateforsure.R
import com.example.dateforsure.databinding.ActivityMainBinding


class SignUp : AppCompatActivity() {

 private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()


    }

    fun goToVerification(v: View){
        val intent = Intent(this, VerificationActivity::class.java)
        startActivity(intent)
    }

    /**
     * field must not be empy
     */
    private fun validateUserName(): Boolean {
        if (binding.username.text.toString().trim().isEmpty()) {

            binding.usernameContainer.error = "Required Field!"
            binding.username.requestFocus()
            return false
        } else {
            binding.usernameContainer.isErrorEnabled = false
        }
        return true
    }


    /**
     * 1) field must not be empty
     * 2) text should matches email address format
     */
    private fun validateUserEmail(): Boolean {
        if (binding.useremail.text.toString().trim().isEmpty()) {
            binding.useremailContainer.error = "Required Field!"
            binding.useremail.requestFocus()
            return false
        } else if (!isValidUserEmail(binding.useremail.text.toString())) {
            binding.emailTextInputLayout.error = "Invalid Email!"
            binding.email.requestFocus()
            return false
        } else {
            binding.useremailContainer.isErrorEnabled = false
        }
        return true
    }

    /**
     * field must not be empy
     */
    private fun validateUsergender(): Boolean {
        if (binding.usergender.text.toString().trim().isEmpty()) {

            binding.usergenderContainer.error = "Required Field!"
            binding.usergender.requestFocus()
            return false
        } else {
            binding.usergenderContainer.isErrorEnabled = false
        }
        return true
    }

    /**
     * 1) field must not be empty
     * 2) password lenght must not be less than 6
     * 3) password must contain at least one digit
     * 4) password must contain atleast one upper and one lower case letter
     * 5) password must contain atleast one special character.
     */
    private fun validatePassword(): Boolean {
        if (binding.userpassword.text.toString().trim().isEmpty()) {
            binding.userpasswordContainer.error = "Required Field!"
            binding.userpassword.requestFocus()
            return false
        } else if (binding.userpassword.text.toString().length < 6) {
            binding.userpasswordContainer.error = "password can't be less than 6"
            binding.userpassword.requestFocus()
            return false
        } else if (!isStringContainNumber(binding.userpassword.text.toString())) {
            binding.userpasswordContainer.error = "Required at least 1 digit"
            binding.userpassword.requestFocus()
            return false
        } else if (!isStringLowerAndUpperCase(binding.userpassword.text.toString())) {
            binding.userpasswordContainer.error =
                "Password must contain upper and lower case letters"
            binding.userpassword.requestFocus()
            return false
        } else if (!isStringContainSpecialCharacter(binding.userpassword.text.toString())) {
            binding.userpasswordContainer.error = "1 special character required"
            binding.userpassword.requestFocus()
            return false
        } else {
            binding.userpasswordContainer.isErrorEnabled = false
        }
        return true
    }


    private fun setupListeners() {
        binding.username.addTextChangedListener(TextFieldValidation(binding.username))
        binding.useremail.addTextChangedListener(TextFieldValidation(binding.useremail))
        binding.usergender.addTextChangedListener(TextFieldValidation(binding.usergender))
        binding.userpassword.addTextChangedListener(TextFieldValidation(binding.userpassword))
    }


    /**
     * applying text watcher on each text field
     */
    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // checking ids of each text field and applying functions accordingly.
            when (view.id) {
                R.id.username -> {
                    validateUserName()
                }
                R.id.userEmail -> {
                    validateUserEmail()
                }
                R.id.userpassword -> {
                    validatePassword()
                }
                R.id.usergender -> {
                    validateUsergender()
                }
            }
        }
    }

}



/**
 * applying text watcher on each text field
 */
class TextFieldValidation(private val view: View) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // checking ids of each text field and applying functions accordingly.

    }

}