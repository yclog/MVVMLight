package flat.com.mvvmlight.JunitTest

/**
 * Description:
 * Created by wangchengyuan on 2018/9/12.
 */
@Mockable
class Calculator{
    fun add(nums1: Int, nums2: Int): Int{
        return nums1+nums2
    }

    fun performMultiply(nums1: Int, nums2: Int): Int{
        return nums1*nums2
    }

    fun divide(divident: Double, dividor: Double): Double{
        if (dividor == 0.0) throw IllegalArgumentException("Dividor cannot be 0")
        return divident / dividor
    }

    fun testCallback(code: Int,callback: TestCallback){
        if (code == 0)
            callback.onSuccess(code)
        else
            callback.onFailure(code,"参数有误")
    }

}