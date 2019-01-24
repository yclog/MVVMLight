package flat.com.mvvmlight.JunitTrain

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

/**
 * Description:
 *
 * @author wangchengyuan
 * @date 2018/10/22
 */
class IgnoringTest{

    @Ignore("Test is ignored as a demonstration")
    @Test
    fun testIgnore(){
        Assert.assertThat(1,`is`(1))
    }
}