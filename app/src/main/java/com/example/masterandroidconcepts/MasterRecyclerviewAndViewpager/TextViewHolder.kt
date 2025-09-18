package com.example.masterandroidconcepts.MasterRecyclerviewAndViewpager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masterandroidconcepts.R

class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.TextItem) {
        itemView.findViewById<TextView>(R.id.textView).text = item.text
    }
}

class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.ImageItem) {
        itemView.findViewById<ImageView>(R.id.imageView).setImageResource(item.imageId)
    }
}

class VerticalImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.VerticalImageItem) {
        itemView.findViewById<ImageView>(R.id.imageViewVertical).setImageResource(item.imageId)
        itemView.findViewById<TextView>(R.id.textViewDescriptionVertical).text = item.description
    }
}

class HorizontalImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.HorizontalImageItem) {
        itemView.findViewById<ImageView>(R.id.imageViewHorizontal).setImageResource(item.imageId)
        itemView.findViewById<TextView>(R.id.textViewDescriptionHorizontal).text = item.description
    }
}

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.ContactItem) {
        itemView.findViewById<TextView>(R.id.textViewName).text = item.name
        itemView.findViewById<TextView>(R.id.textViewPhone).text = item.phoneNumber
        itemView.findViewById<ImageView>(R.id.imageViewProfile).setImageResource(item.profileImageId)
    }
}

class EmailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.EmailItem) {
        itemView.findViewById<TextView>(R.id.textViewSenderName).text = item.senderName
        itemView.findViewById<TextView>(R.id.textViewSubject).text = item.subject
        itemView.findViewById<TextView>(R.id.textViewTimestamp).text = item.timestamp
    }
}

class MusicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ListItem.MusicItem) {
        itemView.findViewById<ImageView>(R.id.imageViewThumbnail).setImageResource(item.thumbnailId)
        itemView.findViewById<TextView>(R.id.textViewSongName).text = item.songName
        itemView.findViewById<TextView>(R.id.textViewSingerName).text = item.singerName
    }
}

