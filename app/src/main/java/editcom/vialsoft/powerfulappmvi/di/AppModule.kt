package editcom.vialsoft.powerfulappmvi.di

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import editcom.vialsoft.powerfulappmvi.R
import editcom.vialsoft.powerfulappmvi.dataSource.auth.cache.AuthCacheDao
import editcom.vialsoft.powerfulappmvi.dataSource.auth.cache.AuthDatabase
import editcom.vialsoft.powerfulappmvi.dataSource.auth.cache.AuthTokenDao
import editcom.vialsoft.powerfulappmvi.util.Constants
import editcom.vialsoft.powerfulappmvi.util.Constants.BASE_URL
import editcom.vialsoft.powerfulappmvi.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

                     // --------- local data source (cache) ------------//
    @Singleton
    @Provides
    fun provideAuthDatabase(
        @ApplicationContext appContext: Context
    ): AuthDatabase {
        return Room.databaseBuilder(
            appContext,
            AuthDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideAuthCacheDao(db : AuthDatabase) : AuthCacheDao = db.getAccountDetailsDao()

    @Singleton
    @Provides
    fun provideAuthTokenDao(db: AuthDatabase) : AuthTokenDao = db.getAuthTokeDao()

                       // --------- remote data source (web service)------------//

    @Provides
    @Singleton
    fun provideLogInterceptor() : HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient( loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory()) //to convert Call response to LiveData
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


                    ///---------- Others -------------------------------//

    @Singleton
    @Provides
    fun provideGlideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)
    }

    @Singleton
    @Provides
    fun provideGlide(@ApplicationContext application: Context, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

}