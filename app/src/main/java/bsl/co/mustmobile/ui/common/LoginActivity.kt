package bsl.co.mustmobile.ui.common

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import bsl.co.mustmobile.R
import bsl.co.mustmobile.ui.activities.DepartmentSelectionActivity
import bsl.co.mustmobile.ui.activities.Schools.HEALTHSCIENCES
import bsl.co.mustmobile.ui.activities.Schools.SCI
import bsl.co.mustmobile.ui.activities.Schools.SPAS
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {


    private lateinit var toolbar: Toolbar

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        toolbar = findViewById(R.id.toolbar_login)
        setSupportActionBar(toolbar)

        email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.message, 0, 0, 0)
        password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.password, 0, 0, 0)


        email.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)


        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            override fun afterTextChanged(s: Editable) {
                if (s.length != 0) {
                    var drawable = ContextCompat.getDrawable(
                        this@LoginActivity,
                        R.drawable.message
                    ) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(
                        drawable,
                        ContextCompat.getColor(this@LoginActivity, R.color.colordarkblue)
                    ) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    email.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    email.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(this@LoginActivity, R.drawable.message),
                        null, ContextCompat.getDrawable(this@LoginActivity, R.drawable.cancel), null
                    )
                } else if (s.length == 0) {
                    email.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        R.drawable.message,
                        0, 0, 0
                    )
                    var drawable = ContextCompat.getDrawable(this@LoginActivity,R.drawable.message) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(
                        drawable,
                        ContextCompat.getColor(this@LoginActivity,R.color.colorDefault)
                    ) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    email.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    email.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(this@LoginActivity,R.drawable.message),
                        null, null, null
                    )
                }
            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.length != 0) {
                    var drawable = resources.getDrawable(R.drawable.password) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(
                        drawable,
                        resources.getColor(R.color.colordarkblue)
                    ) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    password.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    password.setCompoundDrawablesWithIntrinsicBounds(
                        resources.getDrawable(R.drawable.password),
                        null, resources.getDrawable(R.drawable.cancel), null
                    )
                } else if (s.length == 0) {
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        R.drawable.password,
                        0, 0, 0
                    )
                    var drawable = resources.getDrawable(R.drawable.password) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(
                        drawable,
                        resources.getColor(R.color.colorDefault)
                    ) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    password.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    password.setCompoundDrawablesWithIntrinsicBounds(
                        resources.getDrawable(R.drawable.password),
                        null, null, null
                    )
                }
            }
        })

        email.setOnTouchListener(View.OnTouchListener { v, event ->

            if (event.action == MotionEvent.ACTION_DOWN) {
                if (email.getCompoundDrawables().get(2) != null) {
                    if (event.x >= email.getRight() - email.getLeft() -
                        email.getCompoundDrawables().get(2).getBounds().width()
                    ) {
                        if (email.getText().toString() != "") {
                            email.setText("")
                        }
                    }
                }
            }
            false
        })

        password.setOnTouchListener(View.OnTouchListener { v, event ->

            if (event.action == MotionEvent.ACTION_DOWN) {
                if (password.getCompoundDrawables().get(2) != null) {
                    if (event.x >= password.getRight() - password.getLeft() -
                        password.getCompoundDrawables().get(2).getBounds().width()
                    ) {
                        if (password.getText().toString() != "") {
                            password.setText("")
                        }
                    }
                }
            }
            false
        })

        login_button.setOnClickListener(View.OnClickListener {
            if (validateregID(email.text.toString().trim())) {
                startDashboardActivity()
            } else {
                Toast.makeText(this, "User Does not exist", Toast.LENGTH_LONG).show();
            }

        })
        remember_password.setOnClickListener(View.OnClickListener {

            if (!(remember_password.isSelected)) {
                remember_password.isChecked = true
                remember_password.isSelected = true
                val usname = email.text.toString().trim()
                val pswd = email.text.toString().trim()
                email.setText(usname)
                email.setText(pswd)
            } else {
                email.setText(null)
                email.setText(null)
                remember_password.isChecked = false
                remember_password.isSelected = false
            }
        })
    }

    private fun validateregID(sregid: String): Boolean {
        if (TextUtils.isEmpty(sregid)) {
            //TextViewReversetransaction.setError("Enter Transaction Number Here")
            return false
        } else if (sregid.length < 10 || sregid.length > 10) {
            email.setError("Must be 10 Characters")
            return false
        } else if (sregid.contains("CT")) {
            startActivity(Intent(this, SCI::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
            /*  if (sregid.contains("CT201")){
                  startActivity(Intent(this, SCI::class.java))
                  overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                  finish()
              }*/

        } else if (!sregid.contains("BS")) {
            startActivity(Intent(this, SPAS::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        } else if (!sregid.contains("HS")) {
            startActivity(Intent(this, HEALTHSCIENCES::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        } else {

        }
        return true
    }

    private val loginTextWatcher: TextWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {


        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {


        }

        override fun afterTextChanged(s: Editable) {
            val mUsername: String = email.getText().toString().trim()
            val mPassword: String = password.getText().toString().trim()
            val t = !mUsername.isEmpty() && !mPassword.isEmpty()
            if (t) {
                login_button.setBackgroundResource(R.color.white)
            } else {
                login_button.setBackgroundResource(R.color.colorPrimary)
            }

        }
    }

    override fun onStart() {
        super.onStart()
        val mUsername: String = email.getText().toString().trim()
        val mPassword: String = password.getText().toString().trim()
        val t = !mUsername.isEmpty() && !mPassword.isEmpty()
        if (t) {
            login_button.setBackgroundResource(R.color.white)
        } else {
            login_button.setBackgroundResource(R.color.colorPrimary)
        }
    }

    fun startDashboardActivity() {
        startActivity(Intent(this, DepartmentSelectionActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}