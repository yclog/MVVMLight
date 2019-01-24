package flat.com.mvvmlight.JunitTrain

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

/**
 * Description:
 *
 * @author yclog
 * @date 2018/10/22
 */

@RunWith(Parameterized::class)
class ParameterTest{

    @Parameterized.Parameters
    fun data(): Collection<Object>{
        return Arrays.asList()
    }
}