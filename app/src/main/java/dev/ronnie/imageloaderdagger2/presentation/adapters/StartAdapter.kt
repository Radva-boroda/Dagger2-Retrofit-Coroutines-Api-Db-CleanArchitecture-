package dev.ronnie.imageloaderdagger2.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ronnie.imageloaderdagger2.data.images.Movie
import dev.ronnie.imageloaderdagger2.databinding.ImageItemBinding

class StartAdapter: RecyclerView.Adapter<PicturesViewHolder>() {

    var movies = mutableListOf<Movie>()

    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ImageItemBinding.inflate(inflater, parent, false)
        return PicturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        val movie = movies[position]
        Glide.with(holder.itemView.context).load(movie.thumbnailUrl).into(holder.binding.view1)
            // це додаєш то воно ту саму картинку кидає на кожен кусок
        //Glide.with(holder.itemView.context).load(movie.thumbnailUrl).into(holder.binding.view2)
       // Glide.with(holder.itemView.context).load(movie.thumbnailUrl).into(holder.binding.view3)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class PicturesViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {


}
