package editcom.vialsoft.powerfulappmvi.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import editcom.vialsoft.powerfulappmvi.databinding.ActivityAuthBinding
import editcom.vialsoft.powerfulappmvi.session.SessionManager
import editcom.vialsoft.powerfulappmvi.ui.main.MainActivity
import editcom.vialsoft.powerfulappmvi.viewModels.AuthViewModel
import javax.inject.Inject

/**
 * Injected ViewModel object in activity in order to make sure we have one single instant of
 * a AuthViewModel object in all fragments from auth view.
 */

private const val TAG = "AuthActivity"
@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private val authViewModel: AuthViewModel by viewModels()
    @Inject
    lateinit var sessionManager : SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: onViewCreated ${authViewModel.hashCode()} ")

        subscribeObservers()
    }

    private fun subscribeObservers(){
        authViewModel.viewState.observe(this, {
            Log.d(TAG, "AuthActivity, subscribeObservers: AuthViewState: ${it}")
            it.authToken?.let{
                sessionManager.login(it)
            }
        })

        sessionManager.cachedToken.observe(this, { dataState ->
            Log.d(TAG, "AuthActivity, subscribeObservers: AuthDataState: ${dataState}")
            dataState.let{ authToken ->
                if(authToken != null && authToken.accountPk != -1 && authToken.token != null){
                    navMainActivity()
                }
            }
        })
    }

    private fun navMainActivity(){
        Log.d(TAG, "navMainActivity: called.")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}