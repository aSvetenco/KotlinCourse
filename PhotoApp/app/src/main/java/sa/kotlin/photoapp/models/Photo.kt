package sa.kotlin.photoapp.models

import java.io.Serializable

data class Photo(val id: String,
                 val likes: Int,
                 val favorits: Int,
                 val tags: String,
                 val previewURL: String,
                 val webformatURL: String) : Serializable {

}