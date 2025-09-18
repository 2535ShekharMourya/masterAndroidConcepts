package com.example.masterandroidconcepts.MasterRecyclerviewAndViewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masterandroidconcepts.R

class MultiTypeAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_TEXT = 0
        private const val TYPE_IMAGE = 1
        private const val TYPE_VERTICAL_IMAGE = 2
        private const val TYPE_HORIZONTAL_IMAGE = 3
        private const val TYPE_CONTACT = 4
        private const val TYPE_EMAIL = 5
        private const val TYPE_MUSIC = 6
        private const val TYPE_DANCE = 6
    }


    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is ListItem.TextItem -> TYPE_TEXT
        is ListItem.ImageItem -> TYPE_IMAGE
        is ListItem.VerticalImageItem -> TYPE_VERTICAL_IMAGE
        is ListItem.HorizontalImageItem -> TYPE_HORIZONTAL_IMAGE
        is ListItem.ContactItem -> TYPE_CONTACT
        is ListItem.EmailItem -> TYPE_EMAIL
        is ListItem.MusicItem -> TYPE_MUSIC
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_TEXT -> TextViewHolder(inflater.inflate(R.layout.item_text, parent, false))
            TYPE_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.item_image, parent, false))
            TYPE_VERTICAL_IMAGE -> VerticalImageViewHolder(inflater.inflate(R.layout.item_vertical_image, parent, false))
            TYPE_HORIZONTAL_IMAGE -> HorizontalImageViewHolder(inflater.inflate(R.layout.item_horizontal_image, parent, false))
            TYPE_CONTACT -> ContactViewHolder(inflater.inflate(R.layout.item_contact, parent, false))
            TYPE_EMAIL -> EmailViewHolder(inflater.inflate(R.layout.item_email, parent, false))
            TYPE_MUSIC -> MusicViewHolder(inflater.inflate(R.layout.item_music, parent, false))
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ListItem.TextItem -> (holder as TextViewHolder).bind(item)
            is ListItem.ImageItem -> (holder as ImageViewHolder).bind(item)
            is ListItem.VerticalImageItem -> (holder as VerticalImageViewHolder).bind(item)
            is ListItem.HorizontalImageItem -> (holder as HorizontalImageViewHolder).bind(item)
            is ListItem.ContactItem -> (holder as ContactViewHolder).bind(item)
            is ListItem.EmailItem -> (holder as EmailViewHolder).bind(item)
            is ListItem.MusicItem -> (holder as MusicViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size
}