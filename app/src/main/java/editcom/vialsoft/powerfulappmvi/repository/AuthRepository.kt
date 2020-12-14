package editcom.vialsoft.powerfulappmvi.repository

import editcom.vialsoft.powerfulappmvi.dataSource.apiService.AuthApiService
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthCacheDao
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthTokenDao
import editcom.vialsoft.powerfulappmvi.session.SessionManager

class AuthRepository(
    val authTokenDao: AuthTokenDao,
    val authCacheDao: AuthCacheDao,
    val authApiService: AuthApiService,
    val sessionManager: SessionManager
) {
}