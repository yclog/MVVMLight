package flat.com.mvvmlight.JunitTrain

import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Test

/**
 * Descriptioni:
 *
 * @author yclog
 * @date 2018/10/22
 */
class AssertTest{

    /**
     * assertArrayEquals()方法仅判断数据长度以及内容是否相同，不在意是否为同一个对象
     * **/
    @Test
    fun testAssertArrayEquals(){
        var expected = "trial".toByteArray()
        var actual = "trial".toByteArray()
        Assert.assertArrayEquals("failure - byte arrays not same", expected, actual)
        Assert.assertArrayEquals(expected, actual)
    }

    /**
     * assertSame()方法即用来判断是否为同一对象（同一对象前后内容发生改变也不同），assertNotSame同理
     * 对object使用 == 进行判断，用于对象时为判断堆内存中地址位置是否一致
     * **/
    @Test
    fun testAssertNotSame(){
        Assert.assertSame(Object(), Object())
        Assert.assertNotSame(Object(), Object())
    }

    /**
     * assertEqual()方法同于判断是否为同一对象（同一对象前后内容发生改变也不同）
     * 对object使用 Object.equals()进行判断，用于对象时为判断内容是否一致
     * **/
    @Test
    fun testAssertEqual(){
        val expected = "123"
        val actual = "123"
        Assert.assertEquals(expected, actual)
    }

    /**
     * link：https://junit.org/junit4/javadoc/latest/org/hamcrest/CoreMatchers.html
     * **/
    @Test
    fun testAssertThat(){
        Assert.assertThat("albumen",both(containsString("a")).and(containsString("b")))
        Assert.assertThat("albumen", either(containsString("a")).or(containsString("q")))
    }
}