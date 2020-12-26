package editcom.vialsoft.powerfulappmvi.session

import android.app.Application
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthTokenDao
import javax.inject.Inject

class SessionManager constructor(
    val authToken : AuthTokenDao,
    val application : Application
) {
}