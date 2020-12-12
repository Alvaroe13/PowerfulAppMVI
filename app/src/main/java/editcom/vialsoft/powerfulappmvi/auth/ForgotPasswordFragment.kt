package editcom.vialsoft.powerfulappmvi.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import editcom.vialsoft.powerfulappmvi.R

private const val TAG = "ForgotPasswordFragment"
class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: called")
    }
}