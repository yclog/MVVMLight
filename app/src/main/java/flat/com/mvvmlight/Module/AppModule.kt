package flat.com.mvvmlight.Module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import flat.com.mvvmlight.Model.UserManager
import flat.com.mvvmlight.NetService.NetSetting
import flat.com.mvvmlight.NetService.UserApiService
import flat.com.mvvmlight.Presenter.LoginPresenter
import flat.com.mvvmlight.Utils.PasswordValidator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Description:
 * Created by wangchengyuan on 2018/9/27.
 */
@Module
class AppModule(mContext: Context){
    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit{
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build()
    }

    @Provides
    fun provideBaseUrl(): String{
        return NetSetting.BASE_URL
    }

    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApiService{
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    fun provideUser(preferences: SharedPreferences, userApiService: UserApiService): UserManager{
        return UserManager(preferences, userApiService)
    }

    @Provides
    fun providePasswordValidator(): PasswordValidator{
        return PasswordValidator()
    }

    @Provides
    fun provideLoginPresenter(userManager: UserManager, passwordValidator: PasswordValidator): LoginPresenter{
        return LoginPresenter(userManager, passwordValidator)
    }
}