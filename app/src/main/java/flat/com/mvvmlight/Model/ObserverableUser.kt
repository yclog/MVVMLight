package flat.com.mvvmlight.Model

import android.databinding.ObservableField

/**
 * Description:
 * Created by wangchengyuan on 2018/9/19.
 */
class ObserverableUser{
    val firstName = ObservableField<Any>()
    val lastName = ObservableField<String>()
}