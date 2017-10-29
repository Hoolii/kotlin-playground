package be.renaudraas.kotlinplayground.ui.github

import android.content.Context
import android.content.Intent
import android.os.Bundle
import be.renaudraas.kotlinplayground.R
import be.renaudraas.kotlinplayground.ui.BaseActivity

class GithubActivity : BaseActivity() {

    companion object {
        fun makeIntent(context: Context): Intent {
            val intent = Intent(context, GithubActivity::class.java)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        savedInstanceState ?: let {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, GithubFragment.newInstance())
                    .commit()
        }
    }

}