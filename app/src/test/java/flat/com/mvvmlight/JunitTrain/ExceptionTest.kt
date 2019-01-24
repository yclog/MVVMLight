package flat.com.mvvmlight.JunitTrain

import com.ibm.icu.impl.Assert.fail
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.IndexOutOfBoundsException

/**
 * Description:
 *
 * @author wangchengyuan
 * @date 2018/10/22
 */
class ExceptionTest{

    @Test
    fun testExceptionMessage(){
        try {
            ArrayList<Object>().get(0)
            fail("Expected an IndexOutOfBoundsException to be thrown")
        } catch (e: IndexOutOfBoundsException){
            Assert.assertThat(e.message, `is`("Index: 0, Size: 0"))
        }
    }

    /**
     * when use kotlin should use @get:Rule rather than @Rule
     *
     * */
    @get:Rule
    var thrown = ExpectedException.none()

    /**
     * link：http://baddotrobot.com/blog/2012/03/27/expecting-exception-with-junit-rule/index.html
     *
     * */
    @Test
    @Throws(IndexOutOfBoundsException::class)
    fun shouldTestExceptionMessage() {
        var list = ArrayList<Object>()

        thrown.expect(IndexOutOfBoundsException::class.java)
        thrown.expectMessage("Index: 0, Size: 0")
        list.get(0)
    }
}