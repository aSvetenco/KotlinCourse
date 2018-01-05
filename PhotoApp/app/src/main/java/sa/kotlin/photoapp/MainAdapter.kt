package sa.kotlin.photoapp


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import sa.kotlin.photoapp.models.Photo

class MainAdapter(var photos: List<Photo>,
                  var clickListener: View.OnClickListener) : RecyclerView.Adapter<MainAdapter.PhotoVH>() {
    override fun onBindViewHolder(holder: PhotoVH?, position: Int) {
        holder?.bind(photos.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoVH {
        val v: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_photo, parent, false)
        return PhotoVH(v)
    }

    override fun getItemCount(): Int = photos.size

    inner class PhotoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tags: TextView
        var likes: TextView
        var favorite: TextView
        var photoImage: ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }

            tags = itemView.findViewById(R.id.tags) as TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favorite = itemView.findViewById(R.id.favorites) as TextView
            photoImage = itemView.findViewById(R.id.photo_item) as ImageView
        }

        fun bind(photo: Photo) {
            tags.text = photo.tags
            likes.text = photo.likes.toString()
            favorite.text = photo.favorits.toString()
            if (photo.previewURL.isNotEmpty()) {
                Glide.with(itemView?.context)
                        .load(photo.previewURL)
                        .into(photoImage)
            }

        }

    }
}