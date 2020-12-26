package editcom.vialsoft.powerfulappmvi.viewModels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

private const val TAG = "AuthViewModel"
class AuthViewModel @ViewModelInject constructor(
) :ViewModel() {

    init {
        Log.d(TAG, "AutViewModel: triggered ")
    }
}