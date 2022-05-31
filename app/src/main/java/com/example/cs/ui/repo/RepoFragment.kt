package com.example.cs.ui.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cs.R
import com.example.cs.app
import com.example.cs.databinding.FragmentRepoBinding
import com.example.cs.ui.users.UserFragment

class RepoFragment : Fragment() {
    private var _binding: FragmentRepoBinding? = null
    private val binding: FragmentRepoBinding
        get() = _binding!!


    private val viewModel: RepoViewModel by viewModels {
        RepoViewModelFactory(
            requireActivity().app.gitUserRepo
        )
    }

    // тут прописываем агрумент itemClickCallback для адаптера (слушатель нажатия элемента списка)
    private val adapter = RepoAdapter {
        // Toast.makeText(requireContext(), it.html_url, Toast.LENGTH_SHORT).show()

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, UserFragment.newInstance(it))
            .addToBackStack("")
            .commit()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOutgoingEvents() //метод отправляет event
        initIncomingEvents() //метод получает event
        recyclerView() //отображение данных в recycler View

    }

    private fun recyclerView() {
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.recycleView.adapter = adapter

    }


    private fun initIncomingEvents() {
        val userData = ""//binding.enterEditText.text.toString()
        viewModel.onShowRepository(userData)

    }

    private fun initOutgoingEvents() {
        viewModel.repo.observe(requireActivity()) {
            adapter.setData(it)
        }
        viewModel.inProgerss.observe(requireActivity()) {
            if (it) {
                binding.progressBarLayout.visibility = View.VISIBLE
            } else {
                binding.progressBarLayout.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = RepoFragment()
    }
}