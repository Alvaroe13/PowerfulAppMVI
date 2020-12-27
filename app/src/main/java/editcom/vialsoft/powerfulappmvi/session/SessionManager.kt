package editcom.vialsoft.powerfulappmvi.session

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import editcom.vialsoft.powerfulappmvi.dataSource.auth.cache.AuthTokenDao
import javax.inject.Inject

class SessionManager @Inject constructor(
    val authToken : AuthTokenDao,
    @ApplicationContext val application : Context
) {
}