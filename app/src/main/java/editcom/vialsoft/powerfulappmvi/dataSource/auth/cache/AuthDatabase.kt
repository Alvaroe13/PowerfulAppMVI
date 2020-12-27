package editcom.vialsoft.powerfulappmvi.dataSource.auth.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import editcom.vialsoft.powerfulappmvi.model.AccountDetails
import editcom.vialsoft.powerfulappmvi.model.AuthToken

@Database(entities = [AuthToken::class, AccountDetails::class] , version = 1)
abstract class AuthDatabase : RoomDatabase() {

    abstract fun getAuthTokeDao() : AuthTokenDao

    abstract fun getAccountDetailsDao(): AuthCacheDao

}