package editcom.vialsoft.powerfulappmvi.dataSource.auth.apiService

import androidx.lifecycle.LiveData
import editcom.vialsoft.powerfulappmvi.dataSource.auth.network_responses_model.LoginResponse
import editcom.vialsoft.powerfulappmvi.dataSource.auth.network_responses_model.RegistrationResponse
import editcom.vialsoft.powerfulappmvi.util.GenericApiResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApiService {

    @POST("account/login")
    @FormUrlEncoded
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): LiveData<GenericApiResponse<LoginResponse>>

    @POST("account/register")
    @FormUrlEncoded
    fun register(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("password2") password2: String
    ): LiveData<GenericApiResponse<RegistrationResponse>>

}