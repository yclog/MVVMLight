package flat.com.mvvmlight.JunitTest

import java.util.*

/**
 * Description:
 * Created by yclog on 2018/9/12.
 */
interface TestCallback{

    fun onSuccess(data: Int)

    fun onFailure(code: Int, msg: String)
}