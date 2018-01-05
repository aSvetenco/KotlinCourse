package sa.kotlin.photoapp.test

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import sa.kotlin.photoapp.R


class TestActivity : AppCompatActivity(), TestView {

    private val textView: TextView by lazy { findViewById<TextView>(R.id.text_view) }
    private val button: Button by lazy { findViewById<Button>(R.id.button) }
    private val presenter: TestPresenter by lazy { TestPresenter(this)}
    private var isShown: Boolean = true;

    override fun hideHello() {
        textView.setVisibility(GONE)
    }

    override fun sayHello(message: String) {
        textView.setVisibility(VISIBLE)
        textView.setText(message)
    }

    private val TAG: String = "TestActivity"
    var bool: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        setButtonListener();
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun setButtonListener() {
        button.setOnClickListener { l ->

            if (isShown) {
                button.setText("Hide")
                presenter.sayHello("HELLO KOTLIN")
            } else {
                button.setText("Click Me")
                presenter.hideHello()

            }
            isShown = !isShown
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

/*
some tests
 */

    /*  fun variablesTest() {
          var name: String = "Ivan"
          name = "Costean"
          Log.d(TAG, name)
          var name2: String? = null
          val length = name2?.length
          Log.d(TAG, "lenght " + length)
          val length2 = name2?.length ?: -100
          Log.d(TAG, "lenght " + length2)
          try {
              val length3 = name2!!.length
          } catch (e: Exception) {
              Log.d(TAG, e.message, e)
          }
      }

      fun getLength(s: String): Int {
          return s?.length
      }

      fun setListener(view: TextView): Unit {
          view.setOnClickListener({ v ->
              bool = !bool
              if (bool) {
                  v.setBackgroundColor(Color.BLUE)
              } else {
                  v.setBackgroundColor(Color.RED)
              }

          })
      }*/


}
