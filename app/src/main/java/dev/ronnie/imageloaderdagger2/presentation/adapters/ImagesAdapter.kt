package dev.ronnie.imageloaderdagger2.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.ronnie.imageloaderdagger2.dataa.model.MovieItem
import dev.ronnie.imageloaderdagger2.databinding.ImageItemBinding

class ImagesAdapter: PagingDataAdapter<MovieItem, ImagesAdapter.ViewHolder>(DiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                   getItem(position)?.let {
                       Log.i("ViewHolder", "Position")
                       holder.bind(it, position)
                   }
               }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("CreateVH", "context")
        return ViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    inner class ViewHolder(
        private val binding: ImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var movieItem: MovieItem? = null
        fun bind(movieItem: MovieItem, position: Int) {
            Log.i("movie", "transfer")
            this.movieItem = movieItem
            binding.apply {
                image = movieItem
                executePendingBindings()
            }
        }
    }
    private class DiffCallback : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }
    }
}
