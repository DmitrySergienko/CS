package com.example.cs.ui.repo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cs.databinding.ItemGitUserBinding
import com.example.cs.domain.GitUserEntity

class RepoViewHolder(private val binding: ItemGitUserBinding) :
    RecyclerView.ViewHolder(binding.root) {


    companion object {
        fun create(parent: ViewGroup): RepoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return RepoViewHolder(ItemGitUserBinding.inflate(inflater))
        }
    }

    //для открытия другого фрагмента обработку клика необходимо вынести в фрагмент
    //для этого указываем в качестве аргумента Entity, далее идем в адаптер для настройки
    fun bind(item: GitUserEntity, listener: (GitUserEntity) -> Unit) = with(binding) {

        itemGitRepoLogin.text = item.login
        itemGitRepoHtml.text = item.html_url
        avatarImageView.load(item.avatarUrl)
        val avatar = avatarImageView.load(item.avatarUrl)
        root.setOnClickListener {
            listener.invoke(item)
        }
    }
}