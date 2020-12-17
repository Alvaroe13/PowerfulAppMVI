package editcom.vialsoft.powerfulappmvi.dataSource.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import editcom.vialsoft.powerfulappmvi.model.AccountDetails

@Dao
interface AuthCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAndReplace(accountDetails: AccountDetails) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAndIgnore( accountDetails: AccountDetails) : Long

    @Query("SELECT * FROM account_details WHERE pk = :pk")
    fun searchByPk(pk : Int) : AccountDetails

    @Query("SELECT * FROM account_details WHERE email = :email")
    fun searchByEmail(email : String) : AccountDetails?


}