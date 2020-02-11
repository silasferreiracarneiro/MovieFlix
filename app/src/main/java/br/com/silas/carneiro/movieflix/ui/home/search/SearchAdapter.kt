package br.com.silas.carneiro.movieflix.ui.home.search

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.carneiro.movieflix.R
import br.com.silas.carneiro.movieflix.data.network.model.MovieResponse
import br.com.silas.carneiro.movieflix.ui.detail.DetailActivity
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.ITEM_SEARCH_MOVIE
import br.com.silas.carneiro.movieflix.utils.AppConstant.Companion.URL_IMG
import com.bumptech.glide.Glide

class SearchAdapter(var movie: MovieResponse): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_list_movie, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movie.results.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        if(itemCount > 0) {
            val item = movie.results[position]
            holder.title.text = item.title

            holder.play.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                intent.putExtra(ITEM_SEARCH_MOVIE, item)
                holder.itemView.context.startActivity(intent)
            }

            loadPhoto(item.posterPath, holder)
        }
    }

    private fun loadPhoto(posterPath: String, holder: SearchViewHolder) {
        if(posterPath != null && posterPath.isNotBlank() && posterPath.isNotEmpty()){
            val url = URL_IMG + posterPath
            Glide.with(holder.itemView.context)
                .load(url)
                .error(ColorDrawable(Color.RED))
                .into(holder.photo)
        }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.imgMovie)
        val play: ImageView = itemView.findViewById(R.id.imgPlay)
        val title: TextView = itemView.findViewById(R.id.txtTitle)
    }
}