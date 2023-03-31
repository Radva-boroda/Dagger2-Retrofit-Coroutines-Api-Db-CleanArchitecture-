package dev.ronnie.imageloaderdagger2.presentation.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ronnie.imageloaderdagger2.data.images.Movie
import dev.ronnie.imageloaderdagger2.data.images.MovieItem
import dev.ronnie.imageloaderdagger2.databinding.ImageItemBinding
import retrofit2.Call

class StartAdapter: RecyclerView.Adapter<PicturesViewHolder>() {

    var movieList = emptyList<MovieItem>()
@SuppressLint("NotifyDataSetChanger")
    fun setMovie(list: List<MovieItem>) {
        movieList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ImageItemBinding.inflate(inflater, parent, false)
        return PicturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        val movie = movieList[position]
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.view1)
            // це додаєш то воно ту саму картинку кидає на кожен кусок
        //Glide.with(holder.itemView.context).load(movie.thumbnailUrl).into(holder.binding.view2)
       // Glide.with(holder.itemView.context).load(movie.thumbnailUrl).into(holder.binding.view3)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}


class PicturesViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {


}
