package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.PostResponseItem
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.ui.interfaces.ItemClickListener

class AllPostsAdapter(private val posts: List<PostResponseItem>,private val listener: ItemClickListener): RecyclerView.Adapter<AllPostsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllPostsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_all_posts, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: AllPostsAdapter.ViewHolder, position: Int) {
       val item = posts[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(position, item.id)
        }
    }

    override fun getItemCount(): Int {
      return posts.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.titleTextView)
        val body = itemView.findViewById<TextView>(R.id.bodyTextView)
       val id = itemView.findViewById<TextView>(R.id.userIdTextView)
        fun bind(post: PostResponseItem){
            title.text = post.title
            body.text = post.body
            id.text = post.id.toString()
        }

    }
}