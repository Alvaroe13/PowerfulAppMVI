package editcom.vialsoft.powerfulappmvi.viewModels

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import editcom.vialsoft.powerfulappmvi.dataSource.auth.network_responses_model.LoginResponse
import editcom.vialsoft.powerfulappmvi.dataSource.auth.network_responses_model.RegistrationResponse
import editcom.vialsoft.powerfulappmvi.repository.AuthRepository
import editcom.vialsoft.powerfulappmvi.util.GenericApiResponse

private const val TAG = "AuthViewModel"
class AuthViewModel @ViewModelInject constructor(
    private val repository: AuthRepository,
    @Assisted private val savedStateHandle: SavedStateHandle //hilt stuff
) :ViewModel() {

    init {
        Log.d(TAG, "AutViewModel: triggered=  ${doSomething()}" )
        doSomething()
    }

    private fun doSomething() : String{
        return repository.something()
    }

    fun testLogin(): LiveData<GenericApiResponse<LoginResponse>>{
        return repository.testLogin(
            "mitchelltabian@gmail.com",
            "codingwithmitch1"
        )
    }

    fun testRegister(): LiveData<GenericApiResponse<RegistrationResponse>>{
        return repository.testRegistration(
            "alvaroe13@gmail.com",
            "alvaroe13@gmail.com",
            "android1234",
            "android1234"
        )
    }
}