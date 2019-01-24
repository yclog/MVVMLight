package test.com.ktmvvm

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import flat.com.mvvmlight.JunitTest.Calculator
import flat.com.mvvmlight.JunitTest.CalculatorPresenter
import flat.com.mvvmlight.JunitTest.TestCallback
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Ignore
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import java.io.File
import java.util.*
import kotlin.IllegalArgumentException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private var calculator: Calculator = Calculator()

    @Before
    fun setUp(){
        println("Before")
    }

    @After
    fun complete(){
        print("Complete")
    }

    @Test
    @Ignore("not implemented")
    fun testAdd(){
        assertEquals(calculator.add(1,2),3)
        var code = "Green"
        when (code) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
        println(code)
    }

    @Test
    fun testMultiply(){
        assertEquals(calculator.performMultiply(1, 4),4)
    }

    @Test(expected = IllegalArgumentException::class)   //用于测试异常条件是否匹配
    fun testDivide(){
        calculator.divide(2.0, 0.00)
    }

    // mock产生的对象的方法默认什么都不做，或直接返回默认值
    @Test
    fun testCalculatorPresenter(){
        var mCalculator = Mockito.mock(Calculator::class.java)

        var presenter = CalculatorPresenter()
        presenter.setCalculator(mCalculator)
        presenter.multiply(1, 2)

        Mockito.verify(mCalculator, Mockito.times(1)).performMultiply(Mockito.anyInt(), Mockito.anyInt())
    }

    // spy对象的方法默认调用真实的逻辑
    @Test
    fun testSpyFunction(){
        var mCalculator = Mockito.spy(Calculator::class.java)

        var presenter = CalculatorPresenter()
        presenter.setCalculator(mCalculator)

        assertEquals(presenter.multiply(1, 2), 2)
        assertEquals(mCalculator.performMultiply(1, 2), 2)
    }

    @Test
    fun testDoAnswerCallback(){
        var calculator = Mockito.mock(Calculator::class.java)

        Mockito.doAnswer(Answer {
            invocation -> {
            var callback: TestCallback = invocation.getArgument(2)
            callback.onFailure(500, "Server error")
            doReturn(500)
        }
        }).`when`(calculator).testCallback(anyInt(), any())
    }
}
