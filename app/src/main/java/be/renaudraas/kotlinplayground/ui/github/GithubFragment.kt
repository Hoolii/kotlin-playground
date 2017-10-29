package be.renaudraas.kotlinplayground.ui.github

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.renaudraas.kotlinplayground.R
import be.renaudraas.kotlinplayground.business.model.Repository
import be.renaudraas.kotlinplayground.ui.BaseFragment
import kotlinx.android.synthetic.main.github_fragment.*

class GithubFragment : BaseFragment(), GithubMvpView {

    private val presenter = GithubPresenter()
    private var viewHolder: ViewHolder? = null

    companion object {
        fun newInstance(): GithubFragment {
            val f = GithubFragment()

            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.github_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        presenter.fetchRepositories("Hoolii")
    }

    override fun onLoading(isLoading: Boolean) {
        progress.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onRepositoriesFetched(repositories: List<Repository>) {
        Log.d("TEST", "onRepositoriesFetched : ${repositories.size}")
    }

    override fun onError(throwable: Throwable) {
        Log.e("TEST", "onError : ${throwable.printStackTrace()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    class ViewHolder(val progress: View)
}