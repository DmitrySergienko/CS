package com.example.cs.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitUserEntity(

    val name: String,
    val id: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val login: String,
    var html_url: String,
    val nodeID: String,
    val gravatarID: String,
    val followersURL: String,
    val gistsURL: String,
    val subscriptionsURL: String,
    val reposURL: String,
    val email: String,


    ): Parcelable
