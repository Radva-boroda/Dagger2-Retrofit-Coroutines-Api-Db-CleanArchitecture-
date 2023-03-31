package dev.ronnie.imageloaderdagger2.data.images
// Модель по якій прийде файл
data class Movie(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)