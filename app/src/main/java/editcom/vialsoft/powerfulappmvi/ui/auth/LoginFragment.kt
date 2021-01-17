package editcom.vialsoft.powerfulappmvi.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.databinding.FragmentLoginBinding
import editcom.vialsoft.powerfulappmvi.ui.auth.state.LoginFields
import editcom.vialsoft.powerfulappmvi.viewModels.AuthViewModel

private const val TAG = "LoginFragment"
@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    //ui
    private lateinit var binding : FragmentLoginBinding
    //vars
    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLoginBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: called  ${authViewModel.hashCode()}")
        subscribeObservers()
    }

    private fun subscribeObservers() {
        authViewModel.viewState.observe(viewLifecycleOwner, {
            it.loginFields?.let {loginFields ->

                loginFields.loginEmail?.let {emailInserted ->
                    binding.inputEmail.setText(emailInserted)
                }

                loginFields.loginPassword?.let {passwordInserted->
                    binding.inputPassword.setText(passwordInserted)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        authViewModel.setLoginFields(
            LoginFields(
                binding.inputEmail.text.toString(),
                binding.inputPassword.text.toString()
            )
        )
    }
}