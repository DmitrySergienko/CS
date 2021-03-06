package com.example.cs.data.retrofit

import com.example.cs.data.GitUserRep
import com.example.cs.domain.GitUserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Именно эту имплементацию (retrofit) в App
class RetrofitUsersRepoImpl : GitUserRep {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getUsers(username: String): Single<List<GitUserEntity>> {
        return Single.create { emitter ->
            api.accountList()
                .enqueue(object : Callback<List<GitUserEntity>> {
                    override fun onResponse(
                        call: Call<List<GitUserEntity>>,
                        response: Response<List<GitUserEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitUserEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }
    override fun getUsersRep(username: String): Single<List<GitUserEntity>> {
        return Single.create { emitter ->
            api.listRepos(username)
                .enqueue(object : Callback<List<GitUserEntity>> {
                    override fun onResponse(
                        call: Call<List<GitUserEntity>>,
                        response: Response<List<GitUserEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitUserEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }


}