package sa.kotlin.photoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sa.kotlin.photoapp.api.PhotoRetriever
import sa.kotlin.photoapp.models.PhotoList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity"

    //TODO what does "lateinit" mean???
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        getPhotos();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    private fun getPhotos() {
        val retriever = PhotoRetriever()
        retriever.getPhotos(object: Callback<PhotoList> {
            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.d(TAG, "GetPhotosFail", t)
            }

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    //TODO what does "!!" mean???
                    adapter = MainAdapter(response?.body()?.hits!!, this@MainActivity)
                    recyclerView.adapter = adapter
                }
            }
        })
    }

    override fun onClick(view: View?) {
        val photo = adapter.photos.get(recyclerView.getChildAdapterPosition(view))
        DetailActivity.start(this, photo)
    }
}
