package flat.com.mvvmlight

import android.app.Application
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import flat.com.mvvmlight.JunitTest.Mockable
import flat.com.mvvmlight.View.MainActivity
import flat.com.mvvmlight.View.TargetActivity
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.junit.rules.TestName




/**
 * Description:
 *
 * @author yclog
 * @date 2018/10/8
 */
@Mockable
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [25])
class RobolectricTest{

    @Before
    fun setUp(){

    }

    /**
     *  Robolectric 验证控件点击效果
     * */
    @Test
    fun testPerformClick(){
        var activity = Robolectric.setupActivity(MainActivity::class.java)
        var testButton = activity.findViewById<Button>(R.id.testButton)
        Assert.assertTrue(testButton.isEnabled)
        testButton.performClick()
//        Assert.assertEquals(testButton.text, "Google and Success")
        var expectedIntent = Intent(activity, TargetActivity::class.java)
        val actualIntent = shadowOf(RuntimeEnvironment.application).getNextStartedActivity()
        Assert.assertEquals(expectedIntent.component, actualIntent.component)
    }

    /**
     * Robolectric 验证Activity的LifeCycle
     * */
    @Test
    fun testLifecycle(){
        var activityController = Robolectric.buildActivity(MainActivity::class.java).create().start().visible()
        var activity = activityController.get()
        var lastTv = activity.findViewById<TextView>(R.id.lastNameTv)
        // onCreate处验证操作
        Assert.assertEquals(lastTv.text, "World")
        // onResume处验证操作
        activityController.resume().visible()
        Assert.assertEquals(lastTv.text, "Facebook")
        Assert.assertTrue(lastTv.visibility.equals(View.VISIBLE))
    }

    @Test
    fun testDimensSize(){
        var activityController = Robolectric.buildActivity(MainActivity::class.java).create().start().visible()
        var activity = activityController.get()

        Assert.assertEquals(6, activity.resources.getDimension(R.dimen.image_radius).toInt())
    }

    @get:Rule
    public val name = TestName()

    @Test
    fun testA() {
        assertEquals("testA", name.methodName)
    }

    @Test
    fun testB() {
        assertEquals("testB", name.methodName)
    }
}