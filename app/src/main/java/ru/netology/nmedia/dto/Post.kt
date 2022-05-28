package ru.netology.nmedia.dto

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 0,
    var shares: Double = 14.0,
    var views: Double = 1200050.0,
    var likedByMe: Boolean = false
)