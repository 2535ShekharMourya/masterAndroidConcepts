package com.example.masterandroidconcepts.MasterRecyclerviewAndViewpager

sealed class ListItem {
    data class TextItem(val text: String) : ListItem()

    data class ImageItem(val imageId: Int) : ListItem()

    data class VerticalImageItem(
        val imageId: Int,
        val description: String
    ) : ListItem()

    data class HorizontalImageItem(
        val imageId: Int,
        val description: String
    ) : ListItem()

    data class ContactItem(
        val name: String,
        val phoneNumber: String,
        val profileImageId: Int
    ) : ListItem()

    data class EmailItem(
        val senderName: String,
        val subject: String,
        val timestamp: String
    ) : ListItem()

    data class MusicItem(
        val thumbnailId: Int,
        val songName: String,
        val singerName: String
    ) : ListItem()

}