package editcom.vialsoft.powerfulappmvi.repository

import android.util.Log
import editcom.vialsoft.powerfulappmvi.dataSource.apiService.AuthApiService
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthCacheDao
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthTokenDao
import editcom.vialsoft.powerfulappmvi.session.SessionManager

private const val TAG = "AuthRepository"
class AuthRepository constructor(
    val authTokenDao: AuthTokenDao,
    val authCacheDao: AuthCacheDao,
    val authApiService: AuthApiService,
    val sessionManager: SessionManager
) {
    
    init {
        Log.d(TAG, "triggered: ")
    }
}