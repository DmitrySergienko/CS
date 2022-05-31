package com.example.cs

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.cs.domain.GitUserRep
import com.example.cs.data.retrofit.RetrofitUsersRepoImpl

//создаем app для централизованного доступа к данным (чтобы не создавать реп в каждом актививи и фрагменте)

class App : Application() {
    val gitUserRepo: GitUserRep by lazy { RetrofitUsersRepoImpl() }
}

//для активити
val Context.app: App
    get() = applicationContext as App

//для фрагмента
val Fragment.app: App
    get() = requireActivity().application as App
//get()= requireActivity().app