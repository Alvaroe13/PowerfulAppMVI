package editcom.vialsoft.powerfulappmvi.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "account_details")
data class AccountDetails(

    @SerializedName("pk")
    @Expose
    @PrimaryKey(autoGenerate = false)
    var pk: Int,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("username")
    @Expose
    var username: String,
)