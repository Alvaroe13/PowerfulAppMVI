package editcom.vialsoft.powerfulappmvi.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.databinding.ActivityAuthBinding
import editcom.vialsoft.powerfulappmvi.databinding.ActivityMainBinding
import editcom.vialsoft.powerfulappmvi.session.SessionManager
import editcom.vialsoft.powerfulappmvi.ui.auth.AuthActivity
import javax.inject.Inject

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sessionManager : SessionManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.cachedToken.observe(this, { authToken ->
            Log.d(TAG, "subscribeObservers: authToken= ${authToken}")
            if (authToken == null || authToken.accountPk == -1 || authToken.token == null) {
                navAuthActivity()
                finish()
            }
        })
    }

    private fun navAuthActivity(){
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}