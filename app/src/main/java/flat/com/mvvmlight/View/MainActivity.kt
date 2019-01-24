package flat.com.mvvmlight.View

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import flat.com.mvvmlight.Model.User
import flat.com.mvvmlight.Module.AppComponent
import flat.com.mvvmlight.Module.AppModule
import flat.com.mvvmlight.R
import flat.com.mvvmlight.ViewModel.UserViewModel
import flat.com.mvvmlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewMode: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val user = User("Hello","World")
        mViewMode = UserViewModel(user, this)
        mBinding.vm = mViewMode

        var test = findViewById<LinearLayout>(R.id.test_layout)
        test.setPadding(0,0,0,0)
    }

    override fun onResume() {
        super.onResume()
        val user = User("Hello", "Facebook")
        mViewMode = UserViewModel(user, this)
        mBinding.vm = mViewMode
    }

    fun changeText(view: View){
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
    }

    fun readyGo(){
        intent = Intent(this, TargetActivity::class.java)
        startActivity(intent)
    }
}
