package com.example.cs.ui.users

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.domain.GitUserEntity

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var data: List<GitUserEntity> = emptyList()

    //метод настраивает данные
    fun setData(repos: List<GitUserEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    // передаем данные в наш элемент
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    // получаем отдельный элемент
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitUserEntity = data[pos]

    override fun getItemCount(): Int = data.size
}