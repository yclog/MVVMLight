package flat.com.mvvmlight.ViewModel

import android.content.Context
import android.content.Intent
import android.databinding.ObservableField
import flat.com.mvvmlight.Model.User
import flat.com.mvvmlight.View.MainActivity
import flat.com.mvvmlight.View.TargetActivity

/**
 * Description:
 * Created by wangchengyuan on 2018/9/19.
 */
class UserViewModel(var user: User, var context: Context){
    val info = ObservableField<String>("${user.firstName} and ${user.lastName}")
    val firstName = user.firstName
    val lastName = user.lastName

    fun change(){
        user.firstName = "Google"
        user.lastName = "Success"
        info.set("${user.firstName} and ${user.lastName}")
    }

    fun startTargetActivity(){
        var intent = Intent(context, TargetActivity::class.java)
        context.startActivity(intent)
    }
}