package com.example.cs.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.databinding.ItemUserFragmentBinding
import com.example.cs.domain.GitUserEntity

class UserViewHolder(private val binding: ItemUserFragmentBinding) :
    RecyclerView.ViewHolder(binding.root) {


    companion object {
        fun create(parent: ViewGroup): UserViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return UserViewHolder(ItemUserFragmentBinding.inflate(inflater))
        }
    }

    fun bind(item: GitUserEntity) = with(binding) {

        profileName.text = item.name
        profileHtml.text = item.html_url

    }
}