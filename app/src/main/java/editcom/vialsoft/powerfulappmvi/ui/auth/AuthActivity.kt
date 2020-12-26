package editcom.vialsoft.powerfulappmvi.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import editcom.vialsoft.powerfulappmvi.databinding.ActivityAuthBinding
import editcom.vialsoft.powerfulappmvi.viewModels.AuthViewModel

/**
 * Injected ViewModel object in activity in order to make sure we have one single instant of
 * a AuthViewModel object in all fragments from auth view.
 */

private const val TAG = "AuthActivity"
@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: onViewCreated ${authViewModel.hashCode()} ")
    }
}