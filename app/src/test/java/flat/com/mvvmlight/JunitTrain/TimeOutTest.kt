package flat.com.mvvmlight.JunitTrain

import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Description:
 *
 * @author wangchengyuan
 * @date 2018/10/22
 */
class TimeOutTest{
    var log: String? = null
    private val latch = CountDownLatch(1)


    @Test(timeout = 100)
    fun testTimeOut(){

    }

    @get:Rule
    var globalTimeout = Timeout.seconds(10) // 10 seconds max per method tested

    @Test
    @Throws(Exception::class)
    fun testSleepForTooLong() {
        log += "ran1"
        TimeUnit.SECONDS.sleep(100) // sleep for 100 seconds
    }

    @Test
    @Throws(Exception::class)
    fun testBlockForever() {
        log += "ran2"
        latch.await() // will block
    }
}