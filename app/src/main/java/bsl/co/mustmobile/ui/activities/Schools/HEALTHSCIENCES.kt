package bsl.co.mustmobile.ui.activities.Schools

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import bsl.co.mustmobile.R
import bsl.co.mustmobile.ui.common.DashboadActivity
import kotlinx.android.synthetic.main.health_sciences_activity.*
import java.util.*

class HEALTHSCIENCES : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_sciences_activity)

        val backArrow = ContextCompat.getDrawable(this, R.drawable.ic_baseline_keyboard_arrow_left_24)
        toolbar.navigationIcon = backArrow
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar!!.setDisplayHomeAsUpEnabled(true))
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        next.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, DashboadActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })

    }

    private var back_pressed_time: Long = 0
    private val PERIOD: Long = 2000
    override fun onBackPressed() {
        if (back_pressed_time + PERIOD > System.currentTimeMillis()) super.onBackPressed() else  //Toast.makeText(getBaseContext(), "Press Again To Exit!", Toast.LENGTH_SHORT).show();
            back_pressed_time = System.currentTimeMillis()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }
}
