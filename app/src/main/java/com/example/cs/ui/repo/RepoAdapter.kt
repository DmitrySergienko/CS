package com.example.cs.ui.repo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.domain.GitUserEntity

// настраиваем адаптер для открытия фрагмента
// создаем itemClickCallback в конструкторе (тоесть мы его перекинем в конструктор как аргумент)

class RepoAdapter(private val itemClickCallback: (GitUserEntity) -> Unit) : RecyclerView.Adapter<RepoViewHolder>() {

    private var data: List<GitUserEntity> = emptyList()

    //метод настраивает данные
    fun setData(repos: List<GitUserEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    // передаем данные в наш элемент
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder.create(parent)
    }

    // получаем отдельный элемент
    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickCallback)
    }

    private fun getItem(pos: Int): GitUserEntity = data[pos]

    override fun getItemCount(): Int = data.size
}