package flat.com.mvvmlight.JunitTest

/**
 * Description:
 * Created by wangchengyuan on 2018/9/12.
 */
class CalculatorPresenter{
    private var calculator: Calculator = Calculator()

    fun multiply(nums1: Int, nums2: Int): Int{
        return calculator.performMultiply(nums1, nums2)
    }

    fun setCalculator(calculator: Calculator){
        this.calculator = calculator
    }
}