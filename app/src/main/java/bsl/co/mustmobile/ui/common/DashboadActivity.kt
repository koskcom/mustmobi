package bsl.co.mustmobile.ui.common

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import bsl.co.mustmobile.R
import bsl.co.mustmobile.ui.activities.*
import kotlinx.android.synthetic.main.content_dashboard.*

class DashboadActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_dashboard)


        cardViewExamCard.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ExamCardActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })
        cardViewExamResults.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ExamResultsActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })
        cardViewFeesStatement.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, FeesStatementActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })
        cardViewProfile.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })

        cardViewTimetable.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, TimeTableActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })

        cardViewUnits.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, UnitsActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })

        cardViewBookHostel.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, BookHostelActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })
        cardViewMessages.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MessagesActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_refresh -> {
//                val app = applicationContext as KtuApplication
//                app.getDatasfromServer("ADR16CS016","h@l0w33n")
                true
            }
           /* R.id.action_logout->{
                val sharedPref = getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE)
                with (sharedPref.edit()) {
                    putBoolean(getString(R.string.is_logged_key), false)
                    apply()
                }
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }*/
            else -> super.onOptionsItemSelected(item)
        }
    }

}