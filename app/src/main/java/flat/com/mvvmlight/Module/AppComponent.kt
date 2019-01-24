package flat.com.mvvmlight.Module

import dagger.Component
import flat.com.mvvmlight.Presenter.LoginPresenter

/**
 * Description:
 *
 * @author yclog
 * @date 2018/9/27
 */
@Component(modules = [AppModule::class])
interface AppComponent {
    fun loginPresenter(): LoginPresenter
}
