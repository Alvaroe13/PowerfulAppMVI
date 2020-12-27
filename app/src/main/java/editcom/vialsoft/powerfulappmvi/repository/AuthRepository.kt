package editcom.vialsoft.powerfulappmvi.repository

import android.util.Log
import androidx.lifecycle.LiveData
import editcom.vialsoft.powerfulappmvi.dataSource.auth.apiService.AuthApiService
import editcom.vialsoft.powerfulappmvi.dataSource.auth.cache.AuthCacheDao
import editcom.vialsoft.powerfulappmvi.dataSource.auth.cache.AuthTokenDao
import editcom.vialsoft.powerfulappmvi.dataSource.auth.network_responses_model.LoginResponse
import editcom.vialsoft.powerfulappmvi.dataSource.auth.network_responses_model.RegistrationResponse
import editcom.vialsoft.powerfulappmvi.session.SessionManager
import editcom.vialsoft.powerfulappmvi.util.GenericApiResponse
import javax.inject.Inject

private const val TAG = "AuthRepository"

class AuthRepository @Inject constructor(
    val authTokenDao: AuthTokenDao,
    val authCacheDao: AuthCacheDao,
    val sessionManager: SessionManager,
    val authApiService: AuthApiService
) {

    init {
        Log.d(TAG, "triggered: ")
    }

    fun something(): String {
        return "This is the repo"
    }

    fun testLogin(email: String, password: String): LiveData<GenericApiResponse<LoginResponse>> {
        return authApiService.login(email, password)
    }

    fun testRegistration(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ):LiveData<GenericApiResponse<RegistrationResponse>>{
        return authApiService.register(email,username, password, confirmPassword)
    }


}