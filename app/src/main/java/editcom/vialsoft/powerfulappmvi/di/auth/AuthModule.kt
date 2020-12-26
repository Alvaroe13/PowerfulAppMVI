package editcom.vialsoft.powerfulappmvi.di.auth

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import editcom.vialsoft.powerfulappmvi.dataSource.apiService.AuthApiService
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthCacheDao
import editcom.vialsoft.powerfulappmvi.dataSource.cache.AuthTokenDao
import editcom.vialsoft.powerfulappmvi.repository.AuthRepository
import editcom.vialsoft.powerfulappmvi.session.SessionManager

@Module
@InstallIn(ActivityComponent::class)
class AuthModule {


    @ActivityScoped
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AuthCacheDao,
        openApiAuthService: AuthApiService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager
        )
    }


}

