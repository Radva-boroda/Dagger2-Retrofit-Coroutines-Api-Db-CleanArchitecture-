package dev.ronnie.imageloaderdagger2.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.ronnie.imageloaderdagger2.dataa.model.MovieItem
import dev.ronnie.imageloaderdagger2.databinding.ImageItemBinding

//1//
class ImagesAdapter: PagingDataAdapter<MovieItem, ImagesAdapter.ViewHolder>(DiffCallback()){

               // 3 //
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                          // 4 //
        getItem(position)?.let { Log.i("ViewHolder", "Position")
            holder.bind(it, position)
        }
      //  Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageView)
    }
                   // 5 //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("CreateVH", "context")
        return ViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    //2//
    inner class ViewHolder(
        private val binding: ImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var movieItem: MovieItem? = null
             // 6 //
        fun bind(movieItem: MovieItem, position: Int) {
            Log.i("movie", "transfer")
            this.movieItem = movieItem
            binding.apply {
                image = movieItem

                executePendingBindings()
            }
        }
    }
          // name це текст щоб привязати .... але думаю що він впринципі не потрібен
    private class DiffCallback : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }
    }
}







    ///////////////////////////////////////
//
//    RecyclerView.Adapter<PicturesViewHolder>()  {
//
//        var movieList = emptyList<MovieItem>()
//    @SuppressLint("NotifyDataSetChanger")
//    fun setMovie(list: Flow<PagingData<MovieItem>>?) {
//        movieList = list
//        notifyDataSetChanged()
//    }
//    @Override
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//
//        val binding = ImageItemBinding.inflate(inflater, parent, false)
//        return PicturesViewHolder(binding)
//    }
//@Override
//    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
//        val movie = movieList[position]
//        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageView)
//    }
//@Override
//    override fun getItemCount(): Int {
//        return movieList.size
//    }
//}
//class PicturesViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
//}
