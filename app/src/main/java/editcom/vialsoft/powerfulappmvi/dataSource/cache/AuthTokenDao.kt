package editcom.vialsoft.powerfulappmvi.dataSource.cache

import androidx.room.*
import editcom.vialsoft.powerfulappmvi.model.AuthToken

@Dao
interface AuthTokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToken( authToken: AuthToken) : Long

    @Query("UPDATE auth_token_table SET token = null WHERE account_pk = :pk")
    fun nullifyToken(pk : Int): Int
}