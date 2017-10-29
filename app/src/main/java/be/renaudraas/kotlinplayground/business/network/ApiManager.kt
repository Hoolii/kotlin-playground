package be.renaudraas.kotlinplayground.business.network

import be.renaudraas.kotlinplayground.R
import be.renaudraas.kotlinplayground.application.PlaygroundApplication
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    val githubApi: GithubApi

    init {
        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(PlaygroundApplication.instance.getString(R.string.config_github_api_base_url))
                .build()

        githubApi = retrofit.create(GithubApi::class.java)
    }
}