package sa.kotlin.photoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import sa.kotlin.photoapp.models.Photo

class DetailActivity : AppCompatActivity() {

    companion object {
        val PHOTO_KEY = "PhotoKey"
        fun start(context: Context, photo: Photo) {
            val intent: Intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PHOTO_KEY, photo)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val selectedPhoto: Photo? = intent.getSerializableExtra(PHOTO_KEY) as Photo?
        val image: ImageView = findViewById(R.id.image)
        selectedPhoto?.webformatURL.let {
            Glide.with(this)
                    .load(selectedPhoto?.webformatURL)
                    .into(image)
        }

        image.setOnClickListener { finish() }
    }
}
