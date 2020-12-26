package editcom.vialsoft.powerfulappmvi.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.viewModels.AuthViewModel

private const val TAG = "RegisterFragment"
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: called ${authViewModel.hashCode()}")
    }
}