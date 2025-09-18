package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.databinding.FragmentJsonPlaceHolderBinding
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.ui.interfaces.ItemClickListener
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.viewmodel.JsonPlaceHolderViewModel
import kotlinx.coroutines.launch

class JsonPlaceHolderFragment : Fragment(), ItemClickListener {
    lateinit var binding: FragmentJsonPlaceHolderBinding
private lateinit var viewModel: JsonPlaceHolderViewModel
lateinit var adapter: AllPostsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_json_place_holder, container, false)
        binding = FragmentJsonPlaceHolderBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[JsonPlaceHolderViewModel::class.java]
        viewModel.fetchPosts()
        viewModel.postsLiveData.observe(viewLifecycleOwner) { posts ->
            binding.recyclerViewAllPosts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = AllPostsAdapter(posts, this)
            binding.recyclerViewAllPosts.adapter = adapter
            Log.d("JsonPlaceHolderFragment", "Number of posts: ${posts.size} amd post: ${posts.toString()}")
        }
    }

    override fun onItemClick(position: Int, itemId: Int) {

    }


}