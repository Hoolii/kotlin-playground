package be.renaudraas.kotlinplayground.ui

import android.os.Bundle
import android.view.View
import be.renaudraas.kotlinplayground.R
import be.renaudraas.kotlinplayground.ui.github.GithubActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<View>(R.id.github).setOnClickListener{
            startActivity(GithubActivity.makeIntent(this))
        }
    }

}