package com.example.cs.data.retrofit

import com.example.cs.domain.GitUserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<GitUserEntity>>

    @GET("users")
    fun accountList(): Call<List<GitUserEntity>>
}