package editcom.vialsoft.powerfulappmvi.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import editcom.vialsoft.powerfulappmvi.model.AuthToken
import editcom.vialsoft.powerfulappmvi.repository.AuthRepository
import editcom.vialsoft.powerfulappmvi.ui.DataState
import editcom.vialsoft.powerfulappmvi.ui.auth.state.AuthStateEvent
import editcom.vialsoft.powerfulappmvi.ui.auth.state.AuthStateEvent.*
import editcom.vialsoft.powerfulappmvi.ui.auth.state.AuthViewState
import editcom.vialsoft.powerfulappmvi.ui.auth.state.LoginFields
import editcom.vialsoft.powerfulappmvi.ui.auth.state.RegistrationFields
import editcom.vialsoft.powerfulappmvi.util.AbsentLiveData

private const val TAG = "AuthViewModel"

class AuthViewModel @ViewModelInject constructor(
    private val repository: AuthRepository,
    @Assisted private val savedStateHandle: SavedStateHandle //hilt stuff
): BaseViewModel<AuthStateEvent, AuthViewState>(){



    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {

        when(stateEvent){

            is LoginAttemptEvent ->{
                return AbsentLiveData.create()
            }
            is RegistrationAttemptEvent ->{
                return AbsentLiveData.create()
            }
            is CheckPreviousAuthEvent -> {
                return AbsentLiveData.create()
            }

        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }


    fun setLoginFields(loginFields: LoginFields){
        val update = getCurrentViewStateOrNew()
        if(update.loginFields == loginFields){
            return
        }
        update.loginFields = loginFields
        _viewState.value = update
    }


    fun setRegistrationFields(registrationFields: RegistrationFields){
        val update = getCurrentViewStateOrNew()
        if(update.registrationFields == registrationFields){
            return
        }
        update.registrationFields = registrationFields
        _viewState.value = update
    }


    fun setAuthToken(authToken: AuthToken){
        val update = getCurrentViewStateOrNew()
        if(update.authToken == authToken){
            return
        }
        update.authToken = authToken
        _viewState.value = update
    }

}