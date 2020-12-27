package editcom.vialsoft.powerfulappmvi.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.util.ApiEmptyResponse
import editcom.vialsoft.powerfulappmvi.util.ApiErrorResponse
import editcom.vialsoft.powerfulappmvi.util.ApiSuccessResponse
import editcom.vialsoft.powerfulappmvi.viewModels.AuthViewModel

private const val TAG = "LoginFragment"
@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: called  ${authViewModel.hashCode()}")


        authViewModel.testLogin().observe(viewLifecycleOwner, { response ->

            when(response){
                is ApiSuccessResponse ->{
                    Log.d(TAG, "LOGIN RESPONSE: ${response.body}")
                }
                is ApiErrorResponse ->{
                    Log.d(TAG, "LOGIN RESPONSE: ${response.errorMessage}")
                }
                is ApiEmptyResponse ->{
                    Log.d(TAG, "LOGIN RESPONSE: Empty Response")
                }
            }
        })

    }
}