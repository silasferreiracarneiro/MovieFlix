package br.com.silas.carneiro.movieflix.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.ui.base.BaseActivity
import br.com.silas.carneiro.movieflix.ui.home.homeMovie.HomeMovieFragment
import br.com.silas.carneiro.movieflix.ui.home.more.MoreFragment
import br.com.silas.carneiro.movieflix.ui.home.search.SearchFragment
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpBottomAppBar()
        defaultFragment()

        fabSearch.setOnClickListener{
            val bottomNavDrawerFragment = SearchFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            android.R.id.home -> {
                defaultFragment()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun defaultFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frame_container, HomeMovieFragment())
        beginTransaction.commit()
    }

    private fun setUpBottomAppBar() {
        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        setSupportActionBar(bottomAppBar)

        bottomAppBar.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.navigation_details -> {
                    val bottomNavDrawerFragment = MoreFragment()
                    bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
                }
            }
            false
        }
    }
}
