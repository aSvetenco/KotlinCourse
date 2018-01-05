package sa.kotlin.photoapp.api

import retrofit2.Call
import retrofit2.http.GET
import sa.kotlin.photoapp.models.PhotoList

interface PhotoApi {
    @GET("?key=7603438-42b6675d63151934a31360c1f&q=nature&image_type=photo")
    fun getPhotos(): Call<PhotoList>
}