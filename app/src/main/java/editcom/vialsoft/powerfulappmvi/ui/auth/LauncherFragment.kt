package editcom.vialsoft.powerfulappmvi.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.databinding.FragmentLauncherBinding

private const val TAG = "LauncherFragment"
class LauncherFragment : Fragment(R.layout.fragment_launcher) {

    private lateinit var binding : FragmentLauncherBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLauncherBinding.bind(view)
        Log.d(TAG, "onViewCreated: called")
        buttonsActions()
    }

    private fun buttonsActions() {
        binding.login.setOnClickListener{
            sendToLoginView()
        }

        binding.register.setOnClickListener {
            sendToRegisterView()
        }

        binding.forgotPassword.setOnClickListener {
            sendToForgotPasswordView()
        }
    }

    private fun sendToForgotPasswordView() {
        findNavController().navigate(R.id.action_launcherFragment_to_forgotPasswordFragment)
    }

    private fun sendToRegisterView() {
        findNavController().navigate(R.id.action_launcherFragment_to_registerFragment)
    }

    private fun sendToLoginView() {
        findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
    }

}