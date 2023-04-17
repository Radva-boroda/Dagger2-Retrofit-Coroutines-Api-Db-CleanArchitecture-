package dev.ronnie.imageloaderdagger2.dataa.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem (val name: String,
                      val imageUrl: String,
                      val category: String): Parcelable