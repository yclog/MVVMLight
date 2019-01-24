package flat.com.mvvmlight.Model

import android.content.SharedPreferences

import flat.com.mvvmlight.NetService.UserApiService

/**
 * Description:
 * Created by yclog on 2018/9/27.
 */
class UserManager(private val mPref: SharedPreferences, private val mRestAdapter: UserApiService)
