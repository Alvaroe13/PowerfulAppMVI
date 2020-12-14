package editcom.vialsoft.powerfulappmvi.session

import android.app.Application
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthTokenDao

class SessionManager(
    val authToken : AuthTokenDao,
    val application : Application
) {
}