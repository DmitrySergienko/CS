package com.example.cs.ui.repo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cs.domain.GitUserRep

class RepoViewModelFactory(private val repo: GitUserRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoViewModel(repo) as T
    }
}