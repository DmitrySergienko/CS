package com.example.cs.data.retrofit

import com.example.cs.domain.GitUserEntity
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

  /*  @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<GitUserEntity>>

    @GET("users")
    fun accountList(): Call<List<GitUserEntity>>

   */

    @GET("users/{user}/repos")
   fun listRepos(@Path("user") user: String?): Deferred<List<GitUserEntity>>

    @GET("users")
    fun accountList(): Deferred<List<GitUserEntity>>

}