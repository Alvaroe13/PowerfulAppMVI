package editcom.vialsoft.powerfulappmvi.di.auth

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import editcom.vialsoft.powerfulappmvi.dataSource.auth.apiService.AuthApiService
import retrofit2.Retrofit

@InstallIn(ActivityComponent::class)
@Module
object AuthModule {

    @ActivityScoped //as long as activity es alive
    @Provides
    fun provideAuhtApiService(retrofit: Retrofit) : AuthApiService =
        retrofit.create(AuthApiService::class.java)


}

