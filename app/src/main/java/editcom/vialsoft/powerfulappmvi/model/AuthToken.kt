package editcom.vialsoft.powerfulappmvi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * This class will be used to keep tack if user is logged in or not,
 * if token is null that means is not. if it's not null that means it is logged in and we
 * should not show auth view
 */

//using foreign key relationship
@Entity(
    tableName = "auth_token_table",
    foreignKeys = [
        ForeignKey(
            entity = AccountDetails::class,
            parentColumns = ["pk"],
            childColumns = ["account_pk"],
            onDelete = CASCADE //erase child table if parent is erased.

        )
    ]
)
class AuthToken(

    @PrimaryKey
    @ColumnInfo(name = "account_pk")
    var accountPk: Int? = -1,

    @ColumnInfo(name = "token")
    @SerializedName("token")
    @Expose
    var token : String? = null

)