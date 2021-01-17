package editcom.vialsoft.powerfulappmvi.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.databinding.FragmentRegisterBinding
import editcom.vialsoft.powerfulappmvi.ui.auth.state.RegistrationFields
import editcom.vialsoft.powerfulappmvi.viewModels.AuthViewModel

private const val TAG = "RegisterFragment"
@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    //ui
    private lateinit var binding: FragmentRegisterBinding
    //vars
    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentRegisterBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: called ${authViewModel.hashCode()}")
        initObservers()
    }

    private fun initObservers() {

        authViewModel.viewState.observe(viewLifecycleOwner, {authViewState ->
            authViewState.registrationFields.let {

                it?.registrationUsername?.let {
                    binding.inputUsername.setText(it)
                }

                it?.registrationEmail?.let {
                    binding.inputEmail.setText(it)
                }

                it?.registrationPassword?.let {
                    binding.inputPassword.setText(it)
                }

                it?.registrationConfirmPassword?.let {
                    binding.inputPasswordConfirm.setText(it)
                }

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        authViewModel.setRegistrationFields(
            RegistrationFields(
                binding.inputUsername.text.toString(),
                binding.inputEmail.text.toString(),
                binding.inputPassword.text.toString(),
                binding.inputPasswordConfirm.text.toString()
            )
        )

    }


}